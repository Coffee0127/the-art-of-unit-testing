package com.osherove.ch3;

public class FileExtensionManager {

    public boolean isValid(String fileName) {
        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("filename has to be provided");
        }

        return fileName.toUpperCase().endsWith(".SLF");
    }

}
