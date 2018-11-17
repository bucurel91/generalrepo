package com.endava.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private  static Map<DataKeys, Object> data = new HashMap<>();

    public static void saveData(DataKeys key, Object value) {
         data.put(key, value);
    }

    public static Object getData(DataKeys key) {
        return data.get(key);
    }
}