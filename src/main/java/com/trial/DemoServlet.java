package com.trial;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

@WebServlet("/test")
public class DemoServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {
        res.setContentType("text/html");//setting the content type
        PrintWriter pw=res.getWriter();//get the stream to write the data

//writing html in the stream
        pw.println("<html><body>");
        pw.println("<h1>Welcome to servlet</h1>");
        pw.println("</body></html>");

        pw.close();//closing the stream
    }}