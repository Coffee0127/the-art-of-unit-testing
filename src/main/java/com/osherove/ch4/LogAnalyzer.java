package com.osherove.ch4;

public class LogAnalyzer {

    private IWebService service;

    public LogAnalyzer(IWebService service) {
        this.service = service;
    }

    public void analyze(String fileName) {
        if (fileName.length() < 8) {
            // 在產品程式中記錄檔名過短的錯誤
            service.logError("Filename too short:" + fileName);
        }
    }

}
