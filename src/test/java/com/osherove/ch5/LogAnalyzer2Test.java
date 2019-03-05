package com.osherove.ch5;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;

public class LogAnalyzer2Test {

    @Test
    public void Analyze_LoggerThrows_CallsWebService() {
        FakeWebService mockWebService = new FakeWebService();
        FakeLogger2 stubLogger = new FakeLogger2();
        stubLogger.willThrow = new RuntimeException("fake exception");

        LogAnalyzer2 analyzer2 = new LogAnalyzer2(stubLogger, mockWebService);
        analyzer2.setMinNameLength(8);
        String tooShortFileName = "abc.ext";
        analyzer2.analyze(tooShortFileName);

        Assert.assertThat(mockWebService.messageToWebService, StringContains.containsString("fake exception"));
    }

    // 用模擬物件來當作一個假的 web 服務
    class FakeWebService implements IWebService {
        private String messageToWebService;

        @Override
        public void write(String message) {
            messageToWebService = message;
        }
    }

    // 用虛設常式物件來模擬 logger 拋出例外
    class FakeLogger2 implements ILogger {
        private String loggerGotMessage;
        private RuntimeException willThrow;

        @Override
        public void logError(String message) {
            loggerGotMessage = message;
            if (willThrow != null) {
                throw willThrow;
            }
        }
    }
}
