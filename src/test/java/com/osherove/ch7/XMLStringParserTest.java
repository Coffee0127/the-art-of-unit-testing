package com.osherove.ch7;

import org.junit.Assert;
import org.junit.Test;

// 衍生子類別
public class XMLStringParserTest extends TemplateStringParserTests {

    private IStringParser getParser(String input) {
        return new XMLStringParser(input);
    }

    // Java 此處 @Test 可省略，由父類別宣告
    @Test
    @Override
    public void TestGetStringVersionFromHeader_SingleDigit_Found() {
        IStringParser parser = getParser("<Header>1</Header>");
        String versionFromHeader = parser.getStringVersionFromHeader();
        Assert.assertEquals("1", versionFromHeader);
    }

    @Test
    @Override
    public void TestGetStringVersionFromHeader_WithMinorVersion_Found() {
        IStringParser parser = getParser("<Header>1.1</Header>");
        String versionFromHeader = parser.getStringVersionFromHeader();
        Assert.assertEquals("1.1", versionFromHeader);
    }

    @Test
    @Override
    public void TestGetStringVersionFromHeader_WithRevision_Found() {
        IStringParser parser = getParser("<Header>1.1.1</Header>");
        String versionFromHeader = parser.getStringVersionFromHeader();
        Assert.assertEquals("1.1.1", versionFromHeader);
    }

}
