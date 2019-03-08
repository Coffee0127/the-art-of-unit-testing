package com.osherove.ch7;

import org.junit.Assert;
import org.junit.Test;

public abstract class FillInTheBlanksStringParserTests {
    // 如果需要，可以預先定義期望的輸出
    public static final String EXPECTED_SINGLE_DIGIT = "1";
    public static final String EXPECTED_WITH_REVISION = "1.1.1";
    public static final String EXPECTED_WITH_MINORVERSION = "1.1";

    // 回傳一個介面的抽象工廠方法
    protected abstract IStringParser getParser(String input);

    // 抽象輸入方法，用來給衍生子類別提供特定格式資料
    protected abstract String getHeaderVersionSingleDigit();

    protected abstract String getHeaderVersionWithMinorVersion();

    protected abstract String getHeaderVersionWithRevision();

    // 根據子類別的輸入，預先定義測試邏輯
    @Test
    public void TestGetStringVersionFromHeader_SingleDigit_Found() {
        String input = getHeaderVersionSingleDigit();
        IStringParser parser = getParser(input);

        String versionFromHeader = parser.getStringVersionFromHeader();
        Assert.assertEquals(EXPECTED_SINGLE_DIGIT, versionFromHeader);
    }

    @Test
    public void TestGetStringVersionFromHeader_WithMinorVersion_Found() {
        String input = getHeaderVersionWithMinorVersion();
        IStringParser parser = getParser(input);

        String versionFromHeader = parser.getStringVersionFromHeader();
        Assert.assertEquals(EXPECTED_WITH_MINORVERSION, versionFromHeader);
    }

    @Test
    public void TestGetStringVersionFromHeader_WithRevision_Found() {
        String input = getHeaderVersionWithRevision();
        IStringParser parser = getParser(input);

        String versionFromHeader = parser.getStringVersionFromHeader();
        Assert.assertEquals(EXPECTED_WITH_REVISION, versionFromHeader);
    }

}
