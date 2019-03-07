package com.osherove.ch7;

import org.junit.After;
import org.junit.Test;

public class LogAnalyzerTest {

    @Test
    public void Analyze_EmptyFile_ThrowsException() {
        LogAnalyzer la = new LogAnalyzer();
        la.analyze("myemptyfile.txt");
        // 測試程式的其他內容
    }

    @After
    public void tearDown() {
        // 在測試之間需要重置靜態資源
        LoggingFacility.setLogger(null);
    }

}
