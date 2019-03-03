package com.osherove.ch3;

public class AlwaysValidFakeExtensionManager implements IExtensionManager {

    @Override
    public boolean isValid(String fileName) {
        return true;
    }

}
