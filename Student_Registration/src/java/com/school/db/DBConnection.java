package com.school.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "victor123");
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}
