package com.johnny.store.common;
import com.johnny.store.dto.ImageDTO;
import com.johnny.store.dto.OrderTransactionDTO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class JsonUtils {
    public static String getJsonStr(Object object){
        JSONObject jsonObject = JSONObject.fromObject(object);
        return jsonObject.toString();
    }

    public static String serializeListToArrayJson(List<Object> list){
        JSONArray json = JSONArray.fromObject(list);
        return json.toString();
    }

    public static List deserializeToObjectList(String jsonStr){
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        return (List) JSONArray.toCollection(jsonArray, ImageDTO.class);
    }

    public static List deserializeToOrderTansactionList(String jsonStr){
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        return (List) JSONArray.toCollection(jsonArray, OrderTransactionDTO.class);
    }
}