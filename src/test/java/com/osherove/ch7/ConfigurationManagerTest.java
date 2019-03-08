package com.osherove.ch7;

import org.junit.Test;

public class ConfigurationManagerTest extends BaseTestClass {

    @Test
    public void Analyze_EmptyFile_ThrowsException() {
        // 呼叫基底類別的輔助方法
        fakeTheLogger();

        ConfigurationManager cm = new ConfigurationManager();
        boolean configured = cm.isConfigured("something");
        // 測試方法的其他內容
    }

}
