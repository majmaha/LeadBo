<%--
  Created by IntelliJ IDEA.
  User: Majd
  Date: 4/11/2017
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>customers</title>
</head>
<body>
<%
    String user=(String)session.getAttribute("user");

    //redirect user to login page if not logged in
    if(user==null){
        response.sendRedirect("index.jsp");
    }
%>
<a href="addCustomer.jsp">1-add customer</a><br>
2-add customer to club<br>
3-change customers obligo<br>
4-attack to wholesaler<br>
5-update debt<br>
<a href="crm.jsp">back</a><br>
<a href="mainMenu.jsp">Home</a><br>
</body>
</html>
