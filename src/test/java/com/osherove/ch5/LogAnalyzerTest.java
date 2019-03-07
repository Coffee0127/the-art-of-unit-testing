package com.osherove.ch5;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

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

    @Test
    public void Analyze_TooShortFileName_CallLogger_ByMockito() {
        // 建立模擬物件
        FakeLogger logger = Mockito.mock(FakeLogger.class);

        LogAnalyzer analyzer = new LogAnalyzer(logger);
        analyzer.setMinNameLength(6);
        analyzer.analyze("a.txt");

        // 使用 Mockito API 來驗證期望結果
        // times(1) 代表某物件某方法應該被呼叫過一次
        Mockito.verify(logger, Mockito.times(1))
            // 預期 logError 傳入參數
            .logError(Matchers.eq("Filename too short: a.txt"));
    }

    class FakeLogger implements ILogger {

        private String lastError;

        @Override
        public void logError(String message) {
            lastError = message;
        }

    }

}
