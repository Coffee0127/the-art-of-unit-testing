package com.osherove.ch3;

public class LogAnalyzerUsingFactoryMethod_AnotherWay {

    public boolean isValidLogFileName(String fileName) {
        return this.isValid(fileName);
    }

    // 設為 protected, 使子類別可改變其行為
    protected boolean isValid(String fileName) {
        FileExtensionManager mgr = new FileExtensionManager();
        return mgr.isValid(fileName);
    }

}
