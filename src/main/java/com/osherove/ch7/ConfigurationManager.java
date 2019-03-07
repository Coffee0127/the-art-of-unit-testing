package com.osherove.ch7;

// 另一個在內部使用 LoggingFacility 的類別
public class ConfigurationManager {

    public boolean isConfigured(String configName) {
        LoggingFacility.log("checking " + configName);
        return true;
    }

}
