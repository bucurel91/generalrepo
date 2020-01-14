package com.endava.utils;

import java.util.ResourceBundle;

public class PropertyManager {

    private static PropertyManager instance;
    private static String browser;
    private static String baseUrl;
    private static String adminUserName;
    private static String adminPass;

    private static final ResourceBundle prop = ResourceBundle.getBundle("configs/config");

    private PropertyManager() {
    }

    public static String getPropertyValue(String key) {
        return prop.getString(key);
    }

    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
            instance.loadData();
        }
        return instance;
    }

    private void loadData() {
        baseUrl = PropertyManager.getPropertyValue("baseUrl");
        browser = PropertyManager.getPropertyValue("browser");
        adminUserName = PropertyManager.getPropertyValue("adminUserName");
        adminPass = PropertyManager.getPropertyValue("adminPass");
    }

    public String getUrl() {
        return baseUrl;
    }

    public String getBrowser() {
        return browser;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public String getAdminPassword() {
        return adminPass;
    }
}
