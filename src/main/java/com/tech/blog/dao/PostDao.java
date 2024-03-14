package com.tech.blog.dao;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostDao {

    Connection conn;
    public PostDao(Connection conn)
    {
        this.conn=conn;
    }

    public ArrayList<Category> getAllCategories()
    {
        ArrayList<Category> list=new ArrayList<>();

        try {
            String q = "select * from categories";
            Statement st = this.conn.createStatement();
            ResultSet set = st.executeQuery(q);
            while (set.next()) {
                int cid = set.getInt("cid");
                String name = set.getString("name");
                String description = set.getString("description");
                Category c = new Category(cid, name, description);
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean savePost(Post post)
    {
        boolean flag=false;

        try {
            String query="insert into posts(pTitle,pContent,pCode,pPic,catId,userId) values(?,?,?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setString(1,post.getpTitle());
            pstmt.setString(2,post.getpContent());
            pstmt.setString(3,post.getpCode());
            pstmt.setString(4,post.getpPic());
            pstmt.setInt(5,post.getCatId());
            pstmt.setInt(6,post.getUserId());

            pstmt.execute();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  flag;
    }

    // get all the post
    public List<Post> getAllPosts()
    {
        List<Post> list=new ArrayList<>();
        //fetch all the post
        try {
            PreparedStatement pstmt=conn.prepareStatement("select * from posts order by pid desc");

            ResultSet resultSet=pstmt.executeQuery();

            while (resultSet.next())
            {
                int pid=resultSet.getInt("pId");
                String pTitle=resultSet.getString("pTitle");
                String pContent=resultSet.getString("pContent");
                String pCode=resultSet.getString("pCode");
                String pPic=resultSet.getString("pPic");
                Timestamp date=resultSet.getTimestamp("pDate");
                int catId=resultSet.getInt("catId");
                int userId=resultSet.getInt("userId");

                Post post=new Post(pid,pTitle,pContent,pCode,pPic,date,catId,userId);

                // adding object to the list.
                list.add(post);
                //System.out.println("Data pass successfully..");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Post> getAllPostByCatId(int catId)
    {
        List<Post> list=new ArrayList<>();
        //fetch all the post by id
        try {
            PreparedStatement pstmt=conn.prepareStatement("select * from posts where catId=?");
            pstmt.setInt(1,catId);
            ResultSet resultSet=pstmt.executeQuery();

            while (resultSet.next())
            {
                int pid=resultSet.getInt("pId");
                String pTitle=resultSet.getString("pTitle");
                String pContent=resultSet.getString("pContent");
                String pCode=resultSet.getString("pCode");
                String pPic=resultSet.getString("pPic");
                Timestamp date=resultSet.getTimestamp("pDate");

                int userId=resultSet.getInt("userId");

                Post post=new Post(pid,pTitle,pContent,pCode,pPic,date,catId,userId);

                // adding object to the list.
                list.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Post getPostByPostId(int postId)
    {
        Post post=null;
        String q="select * from posts where pid=?";
        try {

            PreparedStatement pstmt= conn.prepareStatement(q);
            pstmt.setInt(1,postId);

            ResultSet resultSet=pstmt.executeQuery();
            if (resultSet.next())
            {
                int pid=resultSet.getInt("pId");
                String pTitle=resultSet.getString("pTitle");
                String pContent=resultSet.getString("pContent");
                String pCode=resultSet.getString("pCode");
                String pPic=resultSet.getString("pPic");
                Timestamp date=resultSet.getTimestamp("pDate");

                int catId=resultSet.getInt("catId");
                int userId=resultSet.getInt("userId");
                post=new Post(pid,pTitle,pContent,pCode,pPic,date,catId,userId);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  post;
    }
}
