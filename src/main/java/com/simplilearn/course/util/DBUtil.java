package com.simplilearn.course.util;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
        props.load(input);

        String url = props.getProperty("jdbc.url");
        String user = props.getProperty("jdbc.username");
        String pass = props.getProperty("jdbc.password");

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }
}
