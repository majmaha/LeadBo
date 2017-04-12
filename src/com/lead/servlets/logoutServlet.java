package com.lead.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Majd on 4/11/2017.
 */
@WebServlet(name = "logoutServlet",urlPatterns = "/logoutServlet")
public class logoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        HttpSession session=request.getSession();
        session.invalidate();

        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);

        out.print("You are successfully logged out!");
        out.close();
    }
}
