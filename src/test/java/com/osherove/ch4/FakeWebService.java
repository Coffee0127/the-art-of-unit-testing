package com.osherove.ch4;

public class FakeWebService implements IWebService {

    String lastError;
    RuntimeException toThrow;

    @Override
    public void logError(String message) {
        lastError = message;

        if (toThrow != null) {
            throw toThrow;
        }
    }

}
