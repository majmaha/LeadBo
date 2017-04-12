package com.lead.servlets;



import com.lead.ConnectionManager;
import com.lead.dao.loginDao;
import com.lead.dao.registerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


/**
 * Created by Majd on 4/10/2017.
 */
@WebServlet(name = "registerServlet",urlPatterns = "/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String company=request.getParameter("company");
        String password=request.getParameter("password");
        String user=request.getParameter("user");

        if(registerDao.insertUser(company, user, password)){
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);
        }else{
            out.print("<p style=\"color:red\">Error registration</p>");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
