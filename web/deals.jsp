<%@ page import="java.sql.Connection" %>
<%@ page import="com.lead.ConnectionManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Majd
  Date: 4/12/2017
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deals</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<%
    Connection con= ConnectionManager.getConnection();
    PreparedStatement pst=con.prepareStatement("select * from deals;");
    ResultSet rs=pst.executeQuery();
    %>

<table>
    <tr>
        <td>name</td>
        <td>details</td>
        <td>start Date</td>
        <td>end date</td>
        <td>creation date</td>
        <td>deal type</td>
        <td>deal items</td>
        <td>deal customers</td>
        <td>deal branches</td>
    </tr>
    <% while(rs.next()){ %>
    <tr><td><%=rs.getString(1)%></td>
    <td><%=rs.getString(2)%></td>
    <td><%=rs.getDate(3)%></td>
    <td><%=rs.getDate(4)%></td>
    <td><%=rs.getDate(5)%></td>
    <td><%=rs.getString(6)%></td>
    <td><%=rs.getString(7)%></td>
    <td><%=rs.getString(8)%></td>
    <td><%=rs.getString(9)%></td></tr>
    <%
        }
    %>
</table>
<br>
<a href="addDeal.jsp">1-New Deal</a><br>
<a href="mainMenu.jsp">back</a><br>
</body>
</html>
