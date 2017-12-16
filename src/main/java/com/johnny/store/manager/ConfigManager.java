package com.johnny.store.manager;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import com.johnny.store.common.LogUtils;
import com.johnny.store.common.XmlSerializeUtils;
import com.johnny.store.config.ResponseSetting;
import com.johnny.store.constant.ConfigFileConsts;

public class ConfigManager {
    private static List<ResponseSetting> responseSettingList;

    public static ResponseSetting getResponseSetting(String responseCode) throws FileNotFoundException, UnsupportedEncodingException{
        ResponseSetting resSetting = new ResponseSetting();
        if(responseSettingList == null){
            String configPath = ConfigManager.class.getClassLoader().getResource(ConfigFileConsts.RESPONSE_SETTING_FILE).getFile();
            configPath = java.net.URLDecoder.decode(configPath,"utf-8");
            responseSettingList = XmlSerializeUtils.deserializeToObject(configPath);
        }
        for (ResponseSetting responseSetting : responseSettingList) {
            if(responseSetting.getResponseCode().equals(responseCode)){
                resSetting = responseSetting;
            }
        }

        return resSetting;
    }

    public static String getSystemSetting(String key){
        String value = "";
        try {
            String configPath = java.net.URLDecoder.decode(LogUtils.class.getClassLoader().getResource(ConfigFileConsts.SYSTEM_SETTING).getFile(), "utf-8");
            Map<String, String> systemSetting = XmlSerializeUtils.deserializeToObject(configPath);
            value = systemSetting.get(key);
        } catch (Exception e){

        }
        return value;
    }
}
