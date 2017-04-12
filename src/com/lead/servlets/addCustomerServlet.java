package com.lead.servlets;

import com.lead.dao.addCustomerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Majd on 4/11/2017.
 */
@WebServlet(name = "addCustomerServlet",urlPatterns = "/addCustomerServlet")
public class addCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name=request.getParameter("name");
        String ID=request.getParameter("ID");
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
        boolean club=request.getParameter("club")!=null;
        int obligo=Integer.parseInt(request.getParameter("obligo"));
        boolean wholesaler=request.getParameter("wholesaler")!=null;
        int debt=Integer.parseInt(request.getParameter("debt"));
        if(addCustomerDao.insertCustomer(name,ID,address,phone,club,obligo,wholesaler,debt)){
            RequestDispatcher rd=request.getRequestDispatcher("customers.jsp");
            out.print("<p style=\"color:red\">adding customer success</p>");
            rd.forward(request,response);
        }else{
            out.print("<p style=\"color:red\">Error adding customer</p>");
            RequestDispatcher rd=request.getRequestDispatcher("customers.jsp");
            rd.include(request,response);
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
