package com.osherove.ch3;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.amihaiemil.eoyaml.Yaml;
import com.amihaiemil.eoyaml.YamlSequence;

public class FileExtensionManager implements IExtensionManager {

    private static final List<String> AVAILABLE_EXTENSIONS;

    static {
        try {
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/osherove/ch3/fileNameExtensions.yml");
            YamlSequence extensions = Yaml.createYamlInput(resourceAsStream)
                .readYamlMapping()
                .yamlSequence("extensions");
            AVAILABLE_EXTENSIONS = extensions.children().stream()
                .map(yamlNode -> yamlNode.toString().toUpperCase())
                .collect(toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isValid(String fileName) {
        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("filename has to be provided");
        }

        for (String availableExtension : AVAILABLE_EXTENSIONS) {
            if (fileName.toUpperCase().endsWith("." + availableExtension)) {
                return true;
            }
        }
        return false;
    }

}
