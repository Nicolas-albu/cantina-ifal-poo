package com.ifal.cantina.utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.ifal.cantina.model.Model;

import java.io.IOException;
import java.sql.Connection;

public class SetPropertie {

    private static String getPropertie(String keyPropertie) {
        Properties props = new Properties();
        String valuePropertie = null;
        try {
            props.load(new FileInputStream("application.properties"));
            valuePropertie = props.getProperty(keyPropertie);
        } catch (IOException error) {
            System.err.format("Erro ao ler o arquivo de propriedade: %s", error.getMessage());
        }

        return valuePropertie;
    }

    public static void getUrlConnection() {
        String urlConnection = String.format(
                "jdbc:%s://%s:%s/%s",
                getPropertie("db.type"),
                getPropertie("db.host"),
                getPropertie("db.port"),
                getPropertie("db.name"));
    }

    public static Connection addDatas(Connection connection) {
        return new Connection(getUrlConnection());
    }
}
