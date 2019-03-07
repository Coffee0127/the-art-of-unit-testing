package com.osherove.ch7;

public abstract class BaseStringParser implements IStringParser {

    private String stringToParse;

    protected BaseStringParser(String fileName) {
        this.stringToParse = fileName;
    }

    @Override
    public String getStringToParse() {
        return null;
    }

    public abstract boolean hasCorrectHeader();

    public abstract String getStringVersionFromHeader();

}
