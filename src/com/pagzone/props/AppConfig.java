/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.props;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Arias
 */
public class AppConfig {
    private static final String CONFIG_FILE_NAME = "config.properties";
    private static Properties properties;
    
    static {
        properties = new Properties();
        try {
            // Get the directory path of the AppConfig class file
            String currentDir = AppConfig.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            File configFile = new File(currentDir, CONFIG_FILE_NAME);

            // Load properties from the config file
            try (FileInputStream fis = new FileInputStream(configFile)) {
                properties.load(fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}