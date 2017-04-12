package com.lead.servlets;

import com.lead.dao.addDealDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Majd on 4/12/2017.
 */
@WebServlet(name = "addDealServlet",urlPatterns = "/addDealServlet")
public class addDealServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String dealName=request.getParameter("dealName");
        String dealDetails=request.getParameter("dealDetails");
        String dealStartingDate=request.getParameter("dealStartingDate");
        String dealEndingDate=request.getParameter("dealEndingDate");
        String dealType=request.getParameter("dealType");
        String dealItems=request.getParameter("dealItems");
        String dealCustomers=request.getParameter("dealCustomers");
        String dealBranches=request.getParameter("dealBranches");
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
        Date startDate=null;
        try {
            startDate = sdf.parse(dealStartingDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date endDate=null;
        try {
            endDate = sdf.parse(dealEndingDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date curDate=new Date();
        System.out.print(sdf.format(curDate));

        if(addDealDao.insertDeal(dealName,dealDetails,startDate,endDate,curDate,dealType,dealItems,dealCustomers,dealBranches)){
            RequestDispatcher rd=request.getRequestDispatcher("customers.jsp");
            out.print("<p style=\"color:red\">adding Deal success</p>");
            rd.forward(request,response);
        }else{
            out.print("<p style=\"color:red\">Error adding Deal</p>");
            RequestDispatcher rd=request.getRequestDispatcher("customers.jsp");
            rd.include(request,response);
        }
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
