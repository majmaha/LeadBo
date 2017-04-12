package com.lead.servlets;
import com.lead.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.lead.dao.loginDao;
/**
 * Created by Majd on 4/11/2017.
 */
@WebServlet(name = "loginServlet",urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String company=request.getParameter("company");
        String password=request.getParameter("password");
        String user=request.getParameter("user");

        HttpSession session = request.getSession(false);
        if(session!=null)
            session.setAttribute("user", user);

        if(loginDao.validate(company,user,password)){
            RequestDispatcher rd=request.getRequestDispatcher("mainMenu.jsp");
            rd.forward(request,response);
        }else{
            out.print("<p style=\"color:red\">Sorry username or password error</p>");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }
       out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
