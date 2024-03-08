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

    public User getUserByEmailAndPassword(String email, String password) {
        User user=null;


        try {

            String query = "select * from user where email =? and password=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet set = pstmt.executeQuery();
            // Data from the Db
            if (set.next()) {
            // Settting Data to the Object
                user=new User();

                user.setUserId(set.getInt("userId"));
                user.setName(set.getString("name"));
                user.setEmail(set.getString("email"));
                user.setPassword(set.getString("password"));
                user.setGender(set.getString("gender"));
                user.setRdate(set.getTimestamp("rdate"));
                user.setProfile(set.getString("profile"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
