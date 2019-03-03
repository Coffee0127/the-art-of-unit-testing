package com.osherove.ch4;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;

public class LogAnalyzerTest {

    @Test
    public void Analyze_TooShortFileName_CallsWebService() {
        FakeWebService mockWebService = new FakeWebService();
        LogAnalyzer log = new LogAnalyzer(mockWebService);
        String tooShortFileName = "abc.ext";

        log.analyze(tooShortFileName);

        // 針對模擬物件進行驗證
        Assert.assertThat(mockWebService.lastError, StringContains.containsString("Filename too short:abc.ext"));
    }

}
