package com.giaphi.nbi.helpers;

import java.io.IOException;
import java.util.Properties;

public class ConfigHelper {
    private static final String PROP_FILE = "/application.properties";

    public static String getConfig(String key) {
        Properties props = new Properties();
        try {
            props.load(ConfigHelper.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String config = "";
        if (key != null)
            config = props.getProperty(key);
        return config;
    }
}
