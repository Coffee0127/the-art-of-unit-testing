package com.osherove.ch4;

public class FakeWebService implements IWebService {

    String lastError;

    @Override
    public void logError(String message) {
        lastError = message;
    }

}
