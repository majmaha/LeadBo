<%@ page import="java.sql.Connection" %>
<%@ page import="com.lead.ConnectionManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Majd
  Date: 4/12/2017
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
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
    PreparedStatement pst=con.prepareStatement("select * from items;");
    ResultSet rs=pst.executeQuery();
%>
<table>
    <tr>
        <td>name</td>
        <td>barcode</td>
        <td>details</td>
        <td>price</td>

    </tr>
        <% while(rs.next()){ %>
    <tr><td><%=rs.getString(2)%></td>
        <td><%=rs.getString(3)%></td>
        <td><%=rs.getString(4)%></td>
        <td><%=rs.getDouble(5)%></td></tr>
        <%
        }
    %>
</table>
<a href="addItem.jsp">1-Add Item</a><br>
<a href="mainMenu.jsp">back</a>
</body>
</html>
