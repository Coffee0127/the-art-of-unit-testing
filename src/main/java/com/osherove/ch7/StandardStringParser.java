package com.osherove.ch7;

public class StandardStringParser extends BaseStringParser {

    protected StandardStringParser(String fileName) {
        super(fileName);
    }

    @Override
    public boolean hasCorrectHeader() {
        // 解析 標準字串 的邏輯
        return false;
    }

    @Override
    public String getStringVersionFromHeader() {
        // 解析 標準字串 的邏輯
        return "";
    }

}
