package com.mini;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConfig {
    public static Connection getConnection() throws Exception {
        Properties p = new Properties();
        p.load(new FileInputStream("config/db.properties"));

        String url = p.getProperty("db.url");
        String user = p.getProperty("db.user");
        String pass = p.getProperty("db.pass");

        return DriverManager.getConnection(url, user, pass);
    }
}
