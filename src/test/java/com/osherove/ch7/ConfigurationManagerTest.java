package com.osherove.ch7;

import org.junit.After;
import org.junit.Test;

public class ConfigurationManagerTest {

    @Test
    public void Analyze_EmptyFile_ThrowsException() {
        ConfigurationManager cm = new ConfigurationManager();
        boolean configured = cm.isConfigured("something");
        // 測試方法的其他內容
    }

    @After
    public void tearDown() {
        // 在測試之間需要重置靜態資源
        LoggingFacility.setLogger(null);
    }

}
