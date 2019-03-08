package com.osherove.ch7;

import org.junit.Test;

public abstract class TemplateStringParserTests {
    @Test
    public abstract void TestGetStringVersionFromHeader_SingleDigit_Found();

    @Test
    public abstract void TestGetStringVersionFromHeader_WithMinorVersion_Found();

    @Test
    public abstract void TestGetStringVersionFromHeader_WithRevision_Found();
}
