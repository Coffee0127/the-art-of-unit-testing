package com.osherove.ch7;

public class XMLStringParser extends BaseStringParser {

    protected XMLStringParser(String fileName) {
        super(fileName);
    }

    @Override
    public boolean hasCorrectHeader() {
        // 解析 XML 的邏輯
        return false;
    }

    @Override
    public String getStringVersionFromHeader() {
        // 解析 XML 的邏輯
        return "";
    }

}
