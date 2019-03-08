package com.osherove.ch7;

public interface IStringParser {

    String getStringToParse();

    boolean hasCorrectHeader();

    String getStringVersionFromHeader();

}
