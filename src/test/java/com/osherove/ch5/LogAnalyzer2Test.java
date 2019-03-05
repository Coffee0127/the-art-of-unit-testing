package com.osherove.ch5;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

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

    @Test
    public void Analyze_LoggerThrows_CallsWebService_ByMockito() {
        // 請注意 Mockito.spy 出來的物件，若未指定預期行為則會找實際 class 內容
        FakeWebService mockWebService = Mockito.spy(FakeWebService.class);
        // 不論輸入任何參數，模擬拋出例外的行為
        FakeLogger2 stubLogger = Mockito.mock(FakeLogger2.class);
        Mockito.doThrow(new RuntimeException("fake exception"))
            .when(stubLogger).logError(Mockito.anyString());

        LogAnalyzer2 analyzer2 = new LogAnalyzer2(stubLogger, mockWebService);
        analyzer2.setMinNameLength(8);
        String tooShortFileName = "abc.ext";
        analyzer2.analyze(tooShortFileName);

        // 確認 web 服務的模擬物件有被正確呼叫，而且傳入的字串參數包含了 fake exception 的內容
        Mockito.verify(mockWebService, Mockito.times(1))
            .write(Matchers.contains("fake exception"));
    }

    // 用模擬物件來當作一個假的 web 服務
    // 因 FakeWebService 是 inner class，若要搭配 org.mockito.Mockito.spy(java.lang.Class<T>) 需改為 static
    static class FakeWebService implements IWebService {
        private String messageToWebService;

        @Override
        public void write(String message) {
            messageToWebService = message;
        }

        @Override
        public void write(ErrorInfo message) {
            messageToWebService = message.getMessage();
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
