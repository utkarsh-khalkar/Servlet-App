package com.tech.blog.dao;
/*
    Title: user dao class for data base interaction.
    Date: 24:02:2024
    Time: 4:38
    Author: Utkarsh Khalkar
 */

import com.tech.blog.entities.User;
import java.sql.*;
import java.sql.Connection;

//This is for interacting with database
public class Userdao {
    private Connection conn;

    public Userdao(Connection conn) {
        this.conn = conn;
    }

    // method to insert user to database.
    public boolean saveUser(User user)
    {
        boolean f=false;
        try {

            String query="insert into user(name,email,password,gender,about) values(?,?,?,?,?)";
           PreparedStatement pstmt= this.conn.prepareStatement(query);
           pstmt.setString(1,user.getName());
           pstmt.setString(2,user.getEmail());
           pstmt.setString(3,user.getPassword());
           pstmt.setString(4,user.getGender());
           pstmt.setString(5,user.getAbout());

           pstmt.executeUpdate();
           f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
