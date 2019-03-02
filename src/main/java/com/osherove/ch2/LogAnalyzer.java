package com.osherove.ch2;

public class LogAnalyzer {

    public boolean isValidLogFileName(String fileName) {
        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("filename has to be provided");
        }

        if (!fileName.toUpperCase().endsWith(".SLF")) {
            return false;
        }

        return true;
    }

}
