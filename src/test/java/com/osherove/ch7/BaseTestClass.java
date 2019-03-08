package com.osherove.ch7;

import org.junit.After;
import org.mockito.Mockito;

public class BaseTestClass {

    // 重構到一個共用可讀的輔助方法中，供衍生子類別使用
    public ILogger fakeTheLogger() {
        LoggingFacility.setLogger(Mockito.mock(ILogger.class));
        return LoggingFacility.getLogger();
    }

    @After
    public void tearDown() {
        // 在測試之間需要重置靜態資源
        LoggingFacility.setLogger(null);
    }

}
