package com.osherove.ch7;

public class XMLStringParserTest_ByFillInTheBlanks extends FillInTheBlanksStringParserTests {

    @Override
    protected IStringParser getParser(String input) {
        return new XMLStringParser(input);
    }

    @Override
    protected String getHeaderVersionSingleDigit() {
        return "<Header>1</Header>";
    }

    @Override
    protected String getHeaderVersionWithMinorVersion() {
        return "<Header>1.1</Header>";
    }

    @Override
    protected String getHeaderVersionWithRevision() {
        return "<Header>1.1.1</Header>";
    }

}
