package com.osherove.ch5;

public class LogAnalyzer2 {

    private ILogger logger;
    private IWebService webService;
    private int minNameLength;

    public LogAnalyzer2(ILogger logger, IWebService webService) {
        this.logger = logger;
        this.webService = webService;
    }

    public void analyze(String filename) {
        if (filename.length() < minNameLength) {
            try {
                logger.logError(String.format("Filename too short: %s", filename));
            } catch (Exception e) {
                webService.write("Error From Logger: " + e);
            }
        }
    }

    public void analyze2(String filename) {
        if (filename.length() < minNameLength) {
            try {
                logger.logError(String.format("Filename too short: %s", filename));
            } catch (Exception e) {
                webService.write(new ErrorInfo(1000, e.getMessage()));
            }
        }
    }

    public int getMinNameLength() {
        return minNameLength;
    }

    public void setMinNameLength(int minNameLength) {
        this.minNameLength = minNameLength;
    }

}
