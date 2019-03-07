package com.osherove.ch5;

public class LogAnalyzer {
    private int minNameLength;
    private ILogger logger;

    public LogAnalyzer(ILogger logger) {
        this.logger = logger;
    }


    public void analyze(String filename) {
        if (filename.length() < minNameLength) {
            logger.logError(String.format("Filename too short: %s", filename));
        }
    }

    public int getMinNameLength() {
        return minNameLength;
    }

    public void setMinNameLength(int minNameLength) {
        this.minNameLength = minNameLength;
    }
}
