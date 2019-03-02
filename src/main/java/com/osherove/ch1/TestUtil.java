package com.osherove.ch1;

public class TestUtil {

    public static void showProblem(String test, String message) {
        String msg = String.format(
            "---%s---\n" +
            "      %s\n" +
            "--------------------", test, message);
        System.out.println(msg);
    }

}
