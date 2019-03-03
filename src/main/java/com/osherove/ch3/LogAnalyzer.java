package com.osherove.ch3;

public class LogAnalyzer {

    private boolean wasLastFileNameValid;

    public boolean isValidLogFileName(String fileName) {
        wasLastFileNameValid = false;
        if (!isValid(fileName)) {
            return false;
        }

        wasLastFileNameValid = true;
        return true;
    }

    private boolean isValid(String fileName) {
        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("filename has to be provided");
        }

        return fileName.toUpperCase().endsWith(".SLF");
    }

    public boolean isWasLastFileNameValid() {
        return wasLastFileNameValid;
    }

    public void setWasLastFileNameValid(boolean wasLastFileNameValid) {
        this.wasLastFileNameValid = wasLastFileNameValid;
    }

}
