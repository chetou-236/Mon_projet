package com.groupeisi.company.config;

import com.groupeisi.company.entities.AccountEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                PropertiesReader reader = new PropertiesReader("database.properties");

                Configuration configuration = new Configuration();
                Properties settings = new Properties();

                settings.put(AvailableSettings.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(AvailableSettings.HBM2DDL_AUTO, "update");
                settings.put(AvailableSettings.SHOW_SQL, "true");
                settings.put(AvailableSettings.FORMAT_SQL, "true");
                settings.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                Map<String, String> env = System.getenv();
                String dbUrlProd = env.get("DB_URL_PROD");
                String dbUser = env.get("COMPANY_DB_USER");
                String dbPwd = env.get("COMPANY_DB_PWD");

                boolean dockerConfigAvailable =
                        dbUrlProd != null && !dbUrlProd.isBlank() &&
                                dbUser != null && !dbUser.isBlank() &&
                                dbPwd != null && !dbPwd.isBlank();

                if (dockerConfigAvailable) {
                    settings.put(AvailableSettings.URL, dbUrlProd);
                    settings.put(AvailableSettings.USER, dbUser);
                    settings.put(AvailableSettings.PASS, dbPwd);
                } else {
                    settings.put(AvailableSettings.URL, reader.getProperty("db.urlDev"));
                    settings.put(AvailableSettings.USER, reader.getProperty("db.username"));
                    settings.put(AvailableSettings.PASS, reader.getProperty("db.password"));
                }

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(AccountEntity.class);

                ServiceRegistry serviceRegistry =
                        new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties())
                                .build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                LOGGER.error("Erreur Hibernate", e);
                throw new RuntimeException("Échec de l'initialisation Hibernate", e);
            }
        }
        return sessionFactory;
    }
}

