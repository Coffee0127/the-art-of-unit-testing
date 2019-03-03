package com.osherove.ch3;

public class LogAnalyzerUsingFactoryMethod {

    public boolean isValidLogFileName(String fileName) {
        return getManager().isValid(fileName);
    }

    // 設為 protected, 使子類別可改變其行為
    protected IExtensionManager getManager() {
        // 回傳寫死的值
        return new FileExtensionManager();
    }

}
