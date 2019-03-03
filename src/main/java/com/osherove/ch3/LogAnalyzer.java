package com.osherove.ch3;

public class LogAnalyzer {

    private boolean wasLastFileNameValid;

    public boolean isValidLogFileName(String fileName) {
        wasLastFileNameValid = false;
        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("filename has to be provided");
        }

        if (!fileName.toUpperCase().endsWith(".SLF")) {
            return false;
        }

        wasLastFileNameValid = true;
        return true;
    }

    public boolean isWasLastFileNameValid() {
        return wasLastFileNameValid;
    }

    public void setWasLastFileNameValid(boolean wasLastFileNameValid) {
        this.wasLastFileNameValid = wasLastFileNameValid;
    }

}
