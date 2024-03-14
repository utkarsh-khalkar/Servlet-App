package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDao {
    Connection conn;

    public LikeDao(Connection conn) {
        this.conn = conn;
    }

    public boolean insertLike(int pid, int uid) {
        boolean f=false;
        try {
            String query="insert into likes(pid,uid) values(?,? )";
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setInt(1,pid);
            pstmt.setInt(2,uid);
            pstmt.executeUpdate();
            f=true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public int countLikeOnPost(int pid) {
        int cnt=0;
        String query="select count(*) from likes where pid=?";
        try {
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setInt(1,pid);
            ResultSet resultSet=pstmt.executeQuery();
            if (resultSet.next()) {
                int count=resultSet.getInt("count(*)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt;
    }

    public boolean isLikedByUser(int pid, int uid) {
        boolean f=false;

        try {
            String query="select * from likes where pid=? AND uid=?";
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setInt(1,pid);
            pstmt.setInt(2,uid);
            ResultSet resultSet=pstmt.executeQuery();

            if (resultSet.next()) {
                f=true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return f;
    }

    public boolean deleteLike(int pid, int uid) {
        boolean f=false;
        try {
            PreparedStatement pstmt=conn.prepareStatement("delete from likes where where pid=? AND uid=?  ");
            pstmt.setInt(1,pid);
            pstmt.setInt(2,uid);
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return f;
    }
}
