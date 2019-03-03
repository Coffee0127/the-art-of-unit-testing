package com.osherove.ch3;

public class LogAnalyzer {

    private boolean wasLastFileNameValid;

    public boolean isValidLogFileName(String fileName) {
        wasLastFileNameValid = false;
        FileExtensionManager mgr = new FileExtensionManager();
        if (!mgr.isValid(fileName)) {
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
