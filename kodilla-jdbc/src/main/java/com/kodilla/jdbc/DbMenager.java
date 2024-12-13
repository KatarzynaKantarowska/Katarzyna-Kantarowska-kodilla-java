package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DbMenager {
    INSTANCE;

    private Connection conn;

    DbMenager() {
        Properties connectionProps  = new Properties();
        connectionProps .put("user", "kodilla_user");
        connectionProps .put("password", "kodilla_Pass123");
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kodilla_course" +
                            "?serverTimezone=Europe/Warsaw" +
                            "&useSSL=False&allowPublicKeyRetrieval=true",
                    connectionProps );
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    public static DbMenager getInstance() {
        return INSTANCE;
    }
    public Connection getConnection() {
        return conn;
    }
}
