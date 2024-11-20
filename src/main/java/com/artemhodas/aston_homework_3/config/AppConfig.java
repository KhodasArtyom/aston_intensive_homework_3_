package com.artemhodas.aston_homework_3.config;

import org.apache.commons.dbcp2.BasicDataSource;

import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class AppConfig {

    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = new PathMatchingResourcePatternResolver()
                .getResource("application.properties")
                .getInputStream()) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        Properties properties = loadProperties();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(properties.getProperty("db.url"));
        dataSource.setUsername(properties.getProperty("db.username"));
        dataSource.setPassword(properties.getProperty("db.password"));

        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
       sessionFactory.setDataSource(dataSource());
       sessionFactory.setPackagesToScan("com.artemhodas.aston_homework_3.entity");
       sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }
    private java.util.Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql", "true"); //
        properties.put("hibernate.hbm2ddl.auto", "validate");
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
