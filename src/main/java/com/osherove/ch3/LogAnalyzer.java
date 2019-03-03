package com.osherove.ch3;

public class LogAnalyzer {

    private boolean wasLastFileNameValid;
    private IExtensionManager mgr;

    public LogAnalyzer(IExtensionManager mgr) {
        this.mgr = mgr;
    }

    public boolean isValidLogFileName(String fileName) {
        wasLastFileNameValid = false;
        try {
            if (!mgr.isValid(fileName)) {
                return false;
            }
        } catch (Exception e) {
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
