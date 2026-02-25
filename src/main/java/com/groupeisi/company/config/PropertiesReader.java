package com.groupeisi.company.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader(String propertyFileName) {
        try {
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream(propertyFileName);

            if (is == null) {
                throw new RuntimeException(
                        "Fichier properties introuvable : " + propertyFileName
                );
            }

            properties = new Properties();
            properties.load(is);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Erreur lors du chargement du fichier properties", e
            );
        }
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
