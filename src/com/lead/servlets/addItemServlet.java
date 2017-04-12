package com.lead.servlets;



import com.lead.dao.addItemDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Majd on 4/12/2017.
 */
@WebServlet(name = "addItemServlet",urlPatterns = "/addItemServlet")
public class addItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name=request.getParameter("itemName");
        String barcode=request.getParameter("itemBarcode");
        String details=request.getParameter("itemDetails");
        double price=Double.parseDouble(request.getParameter("itemPrice"));
        double cost=Double.parseDouble(request.getParameter("itemCost"));
        boolean withTax=request.getParameter("withTax")!=null;
        boolean weightable=request.getParameter("weightable")!=null;
        if(addItemDao.insertItem(-1,name,barcode,details,price,cost,withTax,weightable,false,0,0)){
            RequestDispatcher rd=request.getRequestDispatcher("items.jsp");
            out.print("<p style=\"color:red\">adding Item success</p>");
            rd.forward(request,response);
        }else{
            out.print("<p style=\"color:red\">Error adding Itm</p>");
            RequestDispatcher rd=request.getRequestDispatcher("items.jsp");
            rd.include(request,response);
        }
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
