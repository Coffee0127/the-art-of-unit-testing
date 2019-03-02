package com.osherove.ch1;

public class SimpleParserTest_WithTestUtil {

    public static void testReturnsZeroWhenEmptyString() {
        String testName = new Object() { }
            .getClass()
            .getEnclosingMethod()
            .getName();

        try {
            SimpleParser p = new SimpleParser();
            int result = p.parseAndSum("0");
            if (result != 0) {
                // System.out.println("*** SimpleParserTests::testReturnsZeroWhenEmptyString:\n" +
                //     "-------\n" +
                //     "Parse and sum should have returned 0 on an empty string");
                TestUtil.showProblem(testName,
                    "Parse and sum should have returned 0 on an empty string");
            }
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            TestUtil.showProblem(testName, e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            SimpleParserTest_WithTestUtil.testReturnsZeroWhenEmptyString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
