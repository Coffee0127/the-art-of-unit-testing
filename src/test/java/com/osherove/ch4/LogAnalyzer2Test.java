package com.osherove.ch4;

import org.junit.Assert;
import org.junit.Test;

public class LogAnalyzer2Test {

    @Test
    public void Analyze_WebServcieThrows_SendsEmail() {
        FakeWebService stubService = new FakeWebService();
        stubService.toThrow = new RuntimeException("fake exception");
        FakeEmailService mockEmail = new FakeEmailService();
        LogAnalyzer2 log = new LogAnalyzer2(stubService, mockEmail);
        String tooShortFileName = "abc.ext";

        log.analyze(tooShortFileName);

        // 建立期望物件
        EmailInfo expectedEmail = new EmailInfo("someone@somewhere.com", "can't log", "fake exception");

        // 驗證實際物件上所有的屬性值是否與期望物件相同
        Assert.assertEquals(expectedEmail, mockEmail.emailInfo);
    }

}
