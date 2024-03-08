package com.tech.blog.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private static Connection conn;
    public static Connection getConnection() throws SQLException
    {
        try {
            if (conn == null) {
                // Driver Class Loading
                Class.forName("com.mysql.cj.jdbc.Driver");


                // create a connection
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog", "root", "12345");
                System.out.println("Connection Established Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
