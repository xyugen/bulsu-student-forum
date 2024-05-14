/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.dao;

import com.pagzone.props.AppConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author Arias
 */
public class DatabaseConnection {
    private static final String JDBC_URL = AppConfig.getProperty("database.jdbcurl");
    private static final String USERNAME = AppConfig.getProperty("database.username");
    private static final String PASSWORD = AppConfig.getProperty("database.password");

    private static DatabaseConnection instance;
    private Connection connection;
    
    private static final DataSource dataSource;
    
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
