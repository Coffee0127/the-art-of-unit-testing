package com.osherove.ch4;

import org.hamcrest.core.StringContains;
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

        Assert.assertThat(mockEmail.to, StringContains.containsString("someone@somewhere.com"));
        Assert.assertThat(mockEmail.body, StringContains.containsString("fake exception"));
        Assert.assertThat(mockEmail.subject, StringContains.containsString("can't log"));
    }

}
