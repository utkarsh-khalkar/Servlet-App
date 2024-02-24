package com.tech.blog.helper;

import java.sql.*;

public class JDBCUtilConnection {

    private JDBCUtilConnection()
    {

    }

    public static  Connection getJDBCConnection() throws SQLException {
        Connection connection=null;

        //2. Established the Connection..
        String url="jdbc:mysql://localhost:3306/techblog";
        String user="root";
        String pass="12345";

        connection=DriverManager.getConnection(url,user,pass);
        if (connection !=null)
            return connection;

        return connection;
    }

    public static  void  closeJDBCConnection(ResultSet resultSet, Statement statement,Connection connection) throws SQLException {
        if(resultSet !=null)
        {
            resultSet.close();
        }
        if (statement !=null)
        {
            statement.close();
        }
        if (connection !=null)
        {
            connection.close();
        }
    }
}
