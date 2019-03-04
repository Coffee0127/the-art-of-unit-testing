package com.osherove.ch5;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;

public class LogAnalyzerTest {

    @Test
    public void Analyze_TooShortFileName_CallLogger() {
        // 建立假物件
        FakeLogger logger = new FakeLogger();

        LogAnalyzer analyzer = new LogAnalyzer(logger);
        analyzer.setMinNameLength(6);
        analyzer.analyze("a.txt");

        // 把假物件當模擬物件來使用並驗證
        Assert.assertThat(logger.lastError, StringContains.containsString("too short"));
    }

    class FakeLogger implements ILogger {

        private String lastError;

        @Override
        public void logError(String message) {
            lastError = message;
        }

    }

}
