package com.osherove.ch5;

public class ErrorInfo {

    private int severity;

    private String message;

    public ErrorInfo(int severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    public int getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

}
