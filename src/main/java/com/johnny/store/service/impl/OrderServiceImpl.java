package com.johnny.store.service.impl;

import com.johnny.store.common.*;
import com.johnny.store.constant.ImageObjectType;
import com.johnny.store.constant.ImageType;
import com.johnny.store.constant.ResponseCodeConsts;
import com.johnny.store.dto.OrderDTO;
import com.johnny.store.dto.OrderTransactionDTO;
import com.johnny.store.dto.UnifiedResponse;
import com.johnny.store.entity.*;
import com.johnny.store.enums.PriorityEnum;
import com.johnny.store.enums.ResponseOptionEnum;
import com.johnny.store.enums.ResponseTypeEnum;
import com.johnny.store.manager.BuildViewModel;
import com.johnny.store.manager.UnifiedResponseManager;
import com.johnny.store.mapper.*;
import com.johnny.store.service.OrderService;
import com.johnny.store.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderTransactionMapper orderTransactionMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ShippingAddressMapper shippingAddressMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private BuildViewModel buildViewModel;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, String cellphone, int recentMonth, String orderStatus) {
        try {
            String beginDate = "N";
            if(recentMonth > 0){
                beginDate = DateUtils.getRecentMonthDateTime(recentMonth);
            }

            int startIndex = (pageNumber - 1) * pageSize;
            int totalCount = orderMapper.searchTotalCount(
                    cellphone.equals("N") ? null : cellphone,
                    beginDate.equals("N") ? null : beginDate,
                    orderStatus.equals("N")? null: orderStatus);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }

            List<OrderEntity> orderEntityList =  orderMapper.searchList(
                    startIndex,
                    pageSize,
                    cellphone.equals("N") ? null : cellphone,
                    beginDate.equals("N") ? null : beginDate,
                    orderStatus.equals("N")? null: orderStatus);

            List<OrderVO> orderVOList = buildOrderVOList(orderEntityList);
            return UnifiedResponseManager.buildSuccessResponse(totalCount, orderVOList);
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList(int startIndex, int pageSize, int customerID, String orderStatus) {
        try {

            List<OrderEntity> orderEntityList =  orderMapper.searchList4Customer(
                    startIndex,
                    pageSize,
                    customerID,
                    orderStatus.equals("N")? null: orderStatus);

            List<OrderVO> orderVOList = buildOrderVOList(orderEntityList);
            return UnifiedResponseManager.buildSuccessResponse(orderVOList.size(), orderVOList);
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public List<OrderVO> buildOrderVOList(List<OrderEntity> orderEntityList) throws StoreException{
        List<OrderVO> orderVOList = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntityList) {
            OrderVO orderVO = new OrderVO();
            CustomerVO customerVO = new CustomerVO();
            ShippingAddressVO shippingAddressVO = new ShippingAddressVO();
            ExpressCompanyVO expressCompanyVO = new ExpressCompanyVO();
            CountryVO countryVO = new CountryVO();
            ProvinceVO provinceVO = new ProvinceVO();
            CityVO cityVO = new CityVO();
            List<OrderTransactionVO> orderTransactionVOList = new ArrayList<>();

            //订单基本信息
            ConvertObjectUtils.convertJavaBean(orderVO, orderEntity);
            orderVO.setOrderID(orderEntity.getOrderID());
            orderVO.setCustomerID(orderEntity.getCustomerID());
            orderVO.setShippingAddressID(orderEntity.getShippingAddressID());
            orderVO.setExpressCompanyID(orderEntity.getExpressCompanyID());

            //订单的客户信息
            CustomerEntity customerEntity = customerMapper.search(orderEntity.getCustomerID());
            if(customerEntity == null){
                throw new StoreException(PriorityEnum.Normal,
                        new Date(),
                        ResponseCodeConsts.CanNotFindCustomer,
                        ResponseTypeEnum.Exception,
                        ResponseOptionEnum.Admin,
                        "Can not find customer, the ID: " + orderEntity.getCustomerID(),
                        null);
            }
            ConvertObjectUtils.convertJavaBean(customerVO, customerEntity);
            customerVO.setCustomerID(customerEntity.getCustomerID());
            orderVO.setCustomerVO(customerVO);

            //订单的配送信息
            ShippingAddressEntity shippingAddressEntity = shippingAddressMapper.search(orderEntity.getShippingAddressID());
            if(shippingAddressEntity == null){
                throw new StoreException(PriorityEnum.Normal,
                        new Date(),
                        ResponseCodeConsts.CanNotFindShippingAddress,
                        ResponseTypeEnum.Exception,
                        ResponseOptionEnum.Admin,
                        "Can not find shipping address, the ID: " + orderEntity.getShippingAddressID(),
                        null);
            }
            ConvertObjectUtils.convertJavaBean(shippingAddressVO, shippingAddressEntity);
            shippingAddressVO.setShippingID(shippingAddressEntity.getShippingID());
            shippingAddressVO.setCustomerID(shippingAddressEntity.getCustomerID());

            shippingAddressVO.setShippingCountryID(shippingAddressEntity.getShippingCountryID());
            CountryEntity countryEntity = countryMapper.search(shippingAddressEntity.getShippingCountryID());
            if(countryEntity == null){
                throw new StoreException(PriorityEnum.Normal,
                        new Date(),
                        ResponseCodeConsts.CanNotFindCountry,
                        ResponseTypeEnum.Exception,
                        ResponseOptionEnum.Admin,
                        "Can not find shipping country, the ID: " + shippingAddressEntity.getShippingCountryID(),
                        null);
            }
            ConvertObjectUtils.convertJavaBean(countryVO, countryEntity);
            shippingAddressVO.setCountryVO(countryVO);

            shippingAddressVO.setShippingProvinceID(shippingAddressEntity.getShippingProvinceID());
            ProvinceEntity provinceEntity = provinceMapper.search(shippingAddressEntity.getShippingProvinceID());
            if(provinceEntity == null){
                throw new StoreException(PriorityEnum.Normal,
                        new Date(),
                        ResponseCodeConsts.CanNotFindProvince,
                        ResponseTypeEnum.Exception,
                        ResponseOptionEnum.Admin,
                        "Can not find shipping province, the ID: " + shippingAddressEntity.getShippingProvinceID(),
                        null);
            }
            ConvertObjectUtils.convertJavaBean(provinceVO, provinceEntity);
            shippingAddressVO.setProvinceVO(provinceVO);

            shippingAddressVO.setShippingCityID(shippingAddressEntity.getShippingCityID());
            CityEntity cityEntity = cityMapper.search(shippingAddressEntity.getShippingCityID());
            if(cityEntity == null){
                throw new StoreException(PriorityEnum.Normal,
                        new Date(),
                        ResponseCodeConsts.CanNotFindCity,
                        ResponseTypeEnum.Exception,
                        ResponseOptionEnum.Admin,
                        "Can not find shipping city, the ID: " + shippingAddressEntity.getShippingCityID(),
                        null);
            }
            ConvertObjectUtils.convertJavaBean(cityVO, cityEntity);
            shippingAddressVO.setCityVO(cityVO);

            orderVO.setShippingAddressVO(shippingAddressVO);

            //订单的快递公司
            ExpressCompanyEntity expressCompanyEntity = expressCompanyMapper.search(orderEntity.getExpressCompanyID());
            if(expressCompanyEntity != null){
                ConvertObjectUtils.convertJavaBean(expressCompanyVO, expressCompanyEntity);
                expressCompanyVO.setCompanyID(expressCompanyEntity.getCompanyID());
                orderVO.setExpressCompanyVO(expressCompanyVO);
            }

            //订单的商品详细
            List<OrderTransactionEntity> orderTransactionEntityList =  orderTransactionMapper.searchList(orderEntity.getOrderID());
            if(orderTransactionEntityList.isEmpty()){
                orderVO.setOrderTransactionList(null);
                continue;
            }
            for (OrderTransactionEntity orderTransactionEntity : orderTransactionEntityList) {
                OrderTransactionVO orderTransactionVO = new OrderTransactionVO();
                ItemEntity itemEntity = itemMapper.search(orderTransactionEntity.getItemID());
                List<ImageEntity> imageEntityList = imageMapper.searchList(orderTransactionEntity.getItemID(), ImageObjectType.ITEM, ImageType.THUMBNAIL);
                if(imageEntityList != null && imageEntityList.size() > 0){
                    itemEntity.setItemImageUrl(imageEntityList.get(0).getImageSrc());
                }
                ItemVO itemVO = buildViewModel.buildItemViewModel(itemEntity);
                ConvertObjectUtils.convertJavaBean(orderTransactionVO, orderTransactionEntity);
                orderTransactionVO.setOrderTransactionID(orderTransactionEntity.getOrderTransactionID());
                orderTransactionVO.setOrderID(orderTransactionEntity.getOrderID());
                orderTransactionVO.setItemID(orderTransactionEntity.getItemID());
                orderTransactionVO.setItemCount(orderTransactionEntity.getItemCount());
                orderTransactionVO.setItemAmount(orderTransactionEntity.getItemAmount());
                orderTransactionVO.setCurrencyType(orderTransactionEntity.getCurrencyType());
                orderTransactionVO.setItemVO(itemVO);
                orderTransactionVOList.add(orderTransactionVO);
            }
            orderVO.setOrderTransactionList(orderTransactionVOList);

            orderVOList.add(orderVO);
        }

        return orderVOList;
    }

    @Override
    public UnifiedResponse changeOrderStatus(Object dto) {
        try {
            OrderDTO orderDTO = (OrderDTO)dto;
            OrderEntity orderEntity = new OrderEntity();
            ConvertObjectUtils.convertJavaBean(orderEntity, orderDTO);
            orderEntity.setOrderID(orderDTO.getOrderID());
            orderEntity.setLastEditUser(orderDTO.getLoginUser());
            int affectRowCount = orderMapper.updateStatus(orderEntity);
            return UnifiedResponseManager.buildSuccessResponse(affectRowCount);
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse updateTrackingInfo(Object dto) {
        try {
            OrderDTO orderDTO = (OrderDTO)dto;
            OrderEntity orderEntity = new OrderEntity();
            ConvertObjectUtils.convertJavaBean(orderEntity, orderDTO);
            orderEntity.setOrderID(orderDTO.getOrderID());
            orderEntity.setExpressCompanyID(orderDTO.getExpressCompanyID());
            orderEntity.setLastEditUser(orderDTO.getLoginUser());
            int affectRowCount = orderMapper.updateTrackingInfo(orderEntity);
            return UnifiedResponseManager.buildSuccessResponse(affectRowCount);
        }catch (Exception ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse find(int orderID) {
        try {
            List<OrderEntity> orderEntityList = new ArrayList<>();
            OrderEntity orderEntity =  orderMapper.search(orderID);
            if(orderEntity == null){
                return UnifiedResponseManager.buildSuccessResponse(0, null);
            }
            orderEntityList.add(orderEntity);
            List<OrderVO> orderVOList = buildOrderVOList(orderEntityList);
            return UnifiedResponseManager.buildSuccessResponse(1, orderVOList.get(0));
        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse existCheck(String name) {
        return null;
    }

    @Override
    public UnifiedResponse add(Object dto) {
        try{
            int affectRowTotal = 0;
            OrderDTO orderDTO = (OrderDTO)dto;
            String[] shoppingCartIdList = orderDTO.getShoppingCartIdList().split(",");
            List orderTransactionDTOList = JsonUtils.deserializeToOrderTansactionList(orderDTO.getOrderItemsJson());
            OrderEntity orderEntity = new OrderEntity();

            //OrderDTO转OrderEntity
            ConvertObjectUtils.convertJavaBean(orderEntity, orderDTO);
            orderEntity.setCustomerID(orderDTO.getCustomerID());
            orderEntity.setShippingAddressID(orderDTO.getShippingAddressID());
            orderEntity.setOrderAmount(orderDTO.getOrderAmount());
            orderEntity.setOrderDate(DateUtils.getCurrentDateTime());
            orderEntity.setOrderStatus("O");
            orderEntity.setInUser(orderDTO.getLoginUser());
            orderEntity.setLastEditUser(orderDTO.getLoginUser());

            //保存订单信息
            int affectRow4Order = orderMapper.insert(orderEntity);
            affectRowTotal = affectRowTotal + affectRow4Order;

            //保存订单明细信息
            for (Object obj : orderTransactionDTOList) {
                OrderTransactionDTO orderTransactionDTO = (OrderTransactionDTO)obj;
                OrderTransactionEntity orderTransactionEntity = new OrderTransactionEntity();
                orderTransactionEntity.setItemID(orderTransactionDTO.getItemID());
                orderTransactionEntity.setItemCount(orderTransactionDTO.getItemCount());
                orderTransactionEntity.setItemAmount(orderTransactionDTO.getItemAmount());
                orderTransactionEntity.setCurrencyType(orderTransactionDTO.getCurrencyType());
                orderTransactionEntity.setOrderID(orderEntity.getOrderID());
                orderTransactionEntity.setInUser(orderDTO.getLoginUser());
                orderTransactionEntity.setLastEditUser(orderDTO.getLoginUser());
                int affectCount4Transaction = orderTransactionMapper.insert(orderTransactionEntity);
                affectRowTotal = affectRowTotal + affectCount4Transaction;
            }

            //更新购物车状态
            for (String shoppingId : shoppingCartIdList) {
                ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
                shoppingCartEntity.setShoppingCartID(Integer.parseInt(shoppingId));
                shoppingCartEntity.setStatus("S");
                shoppingCartEntity.setLastEditUser(orderDTO.getLoginUser());
                int affectRowCount4ShoppingCart = shoppingCartMapper.updateStatus(shoppingCartEntity);
                affectRowTotal = affectRowTotal + affectRowCount4ShoppingCart;
            }
            
            return UnifiedResponseManager.buildSuccessResponseWithID(affectRowTotal, orderEntity.getOrderID());

        } catch (StoreException ex){
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ex.getErrorCode());
        } catch (Exception ex) {
            LogUtils.processExceptionLog(ex);
            return UnifiedResponseManager.buildFailedResponse(ResponseCodeConsts.UnKnownException);
        }
    }

    @Override
    public UnifiedResponse change(Object dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        return null;
    }
}
