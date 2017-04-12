<%--
  Created by IntelliJ IDEA.
  User: Majd
  Date: 4/12/2017
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new Deals</title>
</head>
<body>
<form method="post" action="addDealServlet">
    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Add Deal</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Deal Name:</td>
                <td><input type="text" name="dealName" value="" /></td>
            </tr>
            <tr>
                <td>Deal details:</td>
                <td><input type="text" name="dealDetails" value="" /></td>
            </tr>
            <tr>
                <td>Deal starting date:</td>
                <td><input type="date" data-date-format="DD MM YYYY" name="dealStartingDate" value="" /></td>
            </tr>
            <tr>
                <td>Deal ending date:</td>
                <td><input type="date" data-date-format="DD MM YYYY" name="dealEndingDate" value="" /></td>
            </tr>
            <tr>
                <td>Deal type:</td>
                // todo: items category
                <td><select name="dealType">
                    <option value="volvo">Volvo</option>
                    <option value="saab">Saab</option>
                    <option value="fiat">Fiat</option>
                    <option value="audi">Audi</option>
                </select></td>
            </tr>
            <tr>
                <td>Deal items category:</td>
                // todo: items category
                <td><select name="dealItems">
                    <option value="volvo">Volvo</option>
                    <option value="saab">Saab</option>
                    <option value="fiat">Fiat</option>
                    <option value="audi">Audi</option>
                </select></td>
            </tr>
            <tr>
                <td>Deal customers category:</td>
                // todo: customers category
                <td><select name="dealCustomers">
                    <option value="volvo">Volvo</option>
                    <option value="saab">Saab</option>
                    <option value="fiat">Fiat</option>
                    <option value="audi">Audi</option>
                </select></td>
            </tr>
            <tr>
                <td>Deal branches:</td>
                // todo: customers category
                <td><select name="dealBranches">
                    <option value="volvo">um al fahem</option>
                    <option value="saab">mosmos</option>
                    <option value="fiat">moawyia</option>
                    <option value="audi">baqa</option>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
<br><a href="deals.jsp">back</a>
</body>
</html>
