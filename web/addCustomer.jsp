<%--
  Created by IntelliJ IDEA.
  User: Majd
  Date: 4/11/2017
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCustomer</title>
</head>
<body>
<%
    String user=(String)session.getAttribute("user");

    //redirect user to login page if not logged in
    if(user==null){
        response.sendRedirect("index.jsp");
    }
%>
<form method="post" action="addCustomerServlet">
    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Add Customer</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="" /></td>
            </tr>
            <tr>
                <td>ID:</td>
                <td><input type="number" name="ID" minlength="9" maxlength="9" value="" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" value="" /></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="number" name="phone" minlength="10" maxlength="10" value="" /></td>
            </tr>
            <tr>
                <td>Add to customers club:</td>
                <td><input type="checkbox" name="club" value="" /></td>
            </tr>
            <tr>
                <td>Set Obligo amount:</td>
                <td><input type="number" name="obligo" value="0" /></td>
            </tr>
            <tr>
                <td>Wholesaler:</td>
                <td><input type="checkbox" name="wholesaler" value="" /></td>
            </tr>
            <tr>
                <td>debt</td>
                <td><input type="number" name="debt" value="0" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
<a href="customers.jsp">back</a><br>
<a href="index.jsp">home</a><br>
</body>
</html>
