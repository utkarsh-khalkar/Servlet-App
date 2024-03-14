package com.tech.blog.servlets;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Post;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/AddPostServlet")
@MultipartConfig
public class AddPostServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int cid=Integer.parseInt(request.getParameter("cid"));
            String pTitle=request.getParameter("pTitle");
            String pContent=request.getParameter("pContent");
            String pCode=request.getParameter("pCode");

            Part part=request.getPart("pic");
            // getting current user id

            HttpSession session=request.getSession();
            User user= (User) session.getAttribute("currentUser");

            Post post=new Post(pTitle,pContent,pCode,part.getSubmittedFileName(),null,cid,user.getUserId());


            PostDao postDao=new PostDao(ConnectionProvider.getConnection());

            if(postDao.savePost(post))
            {

                String path = request.getRealPath("/") + "blog_pics" + File.separator + part.getSubmittedFileName();
                Helper.saveFile(part.getInputStream(),path);
                out.println("done");
            }else {
                out.println("error");
            }


            } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
