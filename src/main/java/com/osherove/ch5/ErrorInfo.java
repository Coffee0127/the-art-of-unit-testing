package com.osherove.ch5;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorInfo errorInfo = (ErrorInfo) o;
        return severity == errorInfo.severity &&
            Objects.equals(message, errorInfo.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(severity, message);
    }
}
