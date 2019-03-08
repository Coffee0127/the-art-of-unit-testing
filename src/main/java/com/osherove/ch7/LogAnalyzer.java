package com.osherove.ch7;

// 在這個內別內部使用 LoggingFacility
public class LogAnalyzer {

    public void analyze(String fileName) {
        if (fileName.length() < 8) {
            LoggingFacility.log("Filename too short:" + fileName);
        }
        //rest of the method here
    }

}
