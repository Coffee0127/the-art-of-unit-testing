package com.osherove.ch7;

import org.junit.Assert;
import org.junit.Test;

public class StandardStringParserTest_ByFillInTheBlanks extends FillInTheBlanksStringParserTests {

    @Override
    protected IStringParser getParser(String input) {
        // 填入被測試類別正確的型別
        return new StandardStringParser(input);
    }

    // 替這個需求填入對的格式
    @Override
    protected String getHeaderVersionSingleDigit() {
        return "header;version=1;\n";
    }

    @Override
    protected String getHeaderVersionWithMinorVersion() {
        return "header;version=1.1;\n";
    }

    @Override
    protected String getHeaderVersionWithRevision() {
        return "header;version=1.1.1;\n";
    }

    // 衍生子類別可以加入自己特定的測試
    @Test
    public void ShouldReturnTrue_WithValidHeader() {
        IStringParser parser = getParser(getHeaderVersionSingleDigit());
        boolean hasCorrectHeader = parser.hasCorrectHeader();

        Assert.assertTrue(hasCorrectHeader);
    }

}
