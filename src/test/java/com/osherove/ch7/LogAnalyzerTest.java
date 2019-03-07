package com.osherove.ch7;

import org.junit.Test;

public class LogAnalyzerTest extends BaseTestClass {

    @Test
    public void Analyze_EmptyFile_ThrowsException() {
        // 呼叫基底類別的輔助方法
        fakeTheLogger();

        LogAnalyzer la = new LogAnalyzer();
        la.analyze("myemptyfile.txt");
        // 測試程式的其他內容
    }

}
