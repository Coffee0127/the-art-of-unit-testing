package com.osherove.ch2;

import org.junit.Assert;
import org.junit.Test;

public class LogAnalyzerTest {

    @Test
    public void IsValidLogFileName_BadExtension_ReturnsFalse() {
        // 單元測試包含了三個行為 (3A)
        // 準備 (Arrange) 物件
        LogAnalyzer analyzer = new LogAnalyzer();

        // 操作 (Act) 物件
        boolean result = analyzer.isValidLogFileName("filewithbadextension.foo");

        // 驗證 (Assert) 某件事符合預期
        Assert.assertFalse(result);
    }

}
