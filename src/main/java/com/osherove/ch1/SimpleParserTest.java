package com.osherove.ch1;

public class SimpleParserTest {

    public static void testReturnsZeroWhenEmptyString() {
        try {
            SimpleParser p = new SimpleParser();
            int result = p.parseAndSum("0");
            if (result != 0) {
                System.out.println("*** SimpleParserTests::testReturnsZeroWhenEmptyString:\n" +
                    "-------\n" +
                    "Parse and sum should have returned 0 on an empty string");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            SimpleParserTest.testReturnsZeroWhenEmptyString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
