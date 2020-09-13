package com.jovialcode.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class PropertyUtil  {
    private static String propertyFileName = "env.properties";
    private static Properties properties;

    public PropertyUtil() {
        if(properties != null) return;

        properties = new Properties();
        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream(propertyFileName);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String request){
        return properties.getProperty(request);
    }
}
