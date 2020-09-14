package com.jovialcode.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil  {
    private static String propertyFileName = "env.properties";
    private static Properties properties;

    private PropertyUtil() { }

    public synchronized static String getProperty(String request){
        if (properties == null){
            try (InputStream inputStream = PropertyUtil.class
                    .getClassLoader()
                    .getResourceAsStream(propertyFileName);) {
                properties = new Properties();
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(request);
    }
}
