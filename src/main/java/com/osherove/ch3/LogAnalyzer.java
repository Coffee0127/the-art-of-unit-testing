package com.osherove.ch3;

public class LogAnalyzer {

    private boolean wasLastFileNameValid;

    private IExtensionManager manager;

    public LogAnalyzer() {
        this.manager = ExtensionManagerFactory.create();
    }

    public boolean isValidLogFileName(String fileName) {
        wasLastFileNameValid = false;
        try {
            if (!manager.isValid(fileName)) {
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


    public IExtensionManager getManager() {
        return manager;
    }

    public void setManager(IExtensionManager manager) {
        this.manager = manager;
    }
}
