package com.osherove.ch7;

public class IISLogStringParser extends BaseStringParser {

    protected IISLogStringParser(String fileName) {
        super(fileName);
    }

    @Override
    public boolean hasCorrectHeader() {
        // 解析 IIS Log 的邏輯
        return false;
    }

    @Override
    public String getStringVersionFromHeader() {
        // 解析 IIS Log 的邏輯
        return "";
    }
}
