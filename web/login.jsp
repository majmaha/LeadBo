<%--
  Created by IntelliJ IDEA.
  User: Majd
  Date: 4/11/2017
  Time: 8:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<%
    String user=(String)session.getAttribute("user");

    //redirect user to home page if already logged in
    if(user!=null){
        response.sendRedirect("index.jsp");
    }
%>

<form method="post" action="loginServlet">
    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Company</td>
                <td><input type="text" name="company" value="" /></td>
            </tr>
            <tr>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="user" value="" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr>
                <td colspan="2">Yet Not Registered!! <a href="register.jsp.jsp">Register Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
<a href="index.jsp">home</a>
</body>
</html>
