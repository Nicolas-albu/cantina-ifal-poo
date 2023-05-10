/*
 * This Java source file contains the class responsible for reading the application settings file.
 */
package com.ifal.cantina.utils;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

/**
 * Reading the application settings file.
 * 
 * @author Nicolas Albuquerque R.
 */
public class ReadProperties {
    private static final String PROPERTIES_FILE_NAME = "config.properties";

    /**
     * Gets and returns a property by its key.
     * 
     * @param keyProperty property key you want to discover its value.
     * @return return the value of key property.
     */
    public static String getProperty(String keyProperty) {
        Properties property = new Properties();
        String valueProperty = null;

        try(InputStream fileProperties = ReadProperties
                .class
                .getClassLoader()
                .getResourceAsStream(PROPERTIES_FILE_NAME)) {
            
            property.load(fileProperties);
            valueProperty = property.getProperty(keyProperty);

        } catch (IOException error) {
            System.err.format("Erro ao ler o arquivo de propriedade: %s\n", error.getMessage());
        }
        
        return valueProperty;
    }

    /**
     * @return return the URL connection to database.
     */
    public static String getUrlConnection() {
        return String.format(
                "jdbc:%s://%s:%s/%s",
                getProperty("db.type"),
                getProperty("db.host"),
                getProperty("db.port"),
                getProperty("db.name"));
    }
}
