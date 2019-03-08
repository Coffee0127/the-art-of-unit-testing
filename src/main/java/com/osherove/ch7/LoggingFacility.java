package com.osherove.ch7;

public class LoggingFacility {

    private static ILogger logger;

    public static void log(String text) {
        logger.log(text);
    }

    public static ILogger getLogger() {
        return logger;
    }

    public static void setLogger(ILogger logger) {
        LoggingFacility.logger = logger;
    }

}
