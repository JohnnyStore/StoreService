package com.johnny.store.common;
import net.sf.json.JSONObject;

public class JsonUtils {
    public static String getJsonStr(Object object){
        JSONObject jsonObject = JSONObject.fromObject(object);
        return jsonObject.toString();
    }
}
