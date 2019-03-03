package com.osherove.ch3;

public class ExtensionManagerFactory {

    private static IExtensionManager customManager;

    public static IExtensionManager create() {
        if (customManager != null) {
            return customManager;
        }
        return new FileExtensionManager();
    }

    public static void setCustomManager(IExtensionManager customManager) {
        ExtensionManagerFactory.customManager = customManager;
    }

}
