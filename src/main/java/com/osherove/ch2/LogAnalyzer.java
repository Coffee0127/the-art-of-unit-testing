package com.osherove.ch2;

public class LogAnalyzer {

    public boolean isValidLogFileName(String fileName) {
        if (fileName.endsWith(".SLF")) {
            return false;
        }

        return true;
    }

}
