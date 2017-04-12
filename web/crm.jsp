<%--
  Created by IntelliJ IDEA.
  User: Majd
  Date: 4/11/2017
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRM-Customer Relationship Management</title>
</head>
<body>
<%
    String user=(String)session.getAttribute("user");

    //redirect user to login page if not logged in
    if(user==null){
        response.sendRedirect("index.jsp");
    }
%>
<a href="customers.jsp">1-Customers</a><br>
<a href="customersClub.jsp">2-Customers Club</a><br>
<a href="index.jsp">back</a><br>
</body>
</html>
