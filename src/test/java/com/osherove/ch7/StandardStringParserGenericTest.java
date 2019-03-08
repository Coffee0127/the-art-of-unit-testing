package com.osherove.ch7;

public class StandardStringParserGenericTest extends GenericParserTests<StandardStringParser> {

    @Override
    protected String getInputHeaderSingleDigit() {
        return "Header;1";
    }

}
