<%--
  Created by IntelliJ IDEA.
  User: Majd
  Date: 4/12/2017
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>
</head>
<body>
<form method="post" action="addItemServlet">
    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Add Item</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Item name:</td>
                <td><input type="text" name="itemName" value="" /></td>
            </tr>
            <tr>
                <td>Item Barcode:</td>
                <td><input type="text" name="itemBarcode" value="" /></td>
            </tr>
            <tr>
                <td>Item details:</td>
                <td><input type="text" name="itemDetails" value="" /></td>
            </tr>
            <tr>
                <td>Item Price:</td>
                <td><input type="number" name="itemPrice" value="" /></td>
            </tr>
            <tr>
                <td>Item Cost:</td>
                <td><input type="number" name="itemCost" value="" /></td>
            </tr>
            <tr>
                <td>with tax:</td>
                <td><input type="checkbox" name="withTax" value="" /></td>
            </tr>
            <tr>
                <td>weightable:</td>
                <td><input type="checkbox" name="weightable" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
<a href="items.jsp">back</a>
</body>
</html>
