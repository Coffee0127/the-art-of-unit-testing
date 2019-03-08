package com.osherove.ch7;

import org.junit.Assert;
import org.junit.Test;

public class StandardStringParserTest extends TemplateStringParserTests {

    // 定義解析器的工廠方法
    private StandardStringParser getParser(String input) {
        return new StandardStringParser(input);
    }

    @Test
    @Override
    public void TestGetStringVersionFromHeader_SingleDigit_Found() {
        String input = "header;version=1;\n";
        // 使用工廠方法
        StandardStringParser parser = getParser(input);
        String versionFromHeader = parser.getStringVersionFromHeader();
        Assert.assertEquals("1", versionFromHeader);
    }

    @Test
    @Override
    public void TestGetStringVersionFromHeader_WithMinorVersion_Found() {
        String input = "header;version=1.1;\n";
        // 使用工廠方法
        StandardStringParser parser = getParser(input);
        String versionFromHeader = parser.getStringVersionFromHeader();
        Assert.assertEquals("1.1", versionFromHeader);
    }

    @Test
    @Override
    public void TestGetStringVersionFromHeader_WithRevision_Found() {
        String input = "header;version=1.1.1;\n";
        // 使用工廠方法
        StandardStringParser parser = getParser(input);
        String versionFromHeader = parser.getStringVersionFromHeader();
        Assert.assertEquals("1.1.1", versionFromHeader);
    }

}
