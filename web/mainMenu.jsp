<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>wow</title>
</head>
<body>
<%
    String user=(String)session.getAttribute("user");

    //redirect user to login page if not logged in
    if(user==null){
        response.sendRedirect("index.jsp");
    }
%>
<a href="crm.jsp">1-CRM customer relationship management</a><br>
<a href="deals.jsp">2-Deals</a><br>
<a href="items.jsp">3-Items Catalog</a><br>
4-Inventory Management<br>
5-HR<br>
6-POSes<br>
<a href="logoutServlet">Logout</a><br>
</body>
</html>