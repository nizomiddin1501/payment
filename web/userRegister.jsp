<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/25/2024
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CurrentTitle</title>
</head>
<body>

<h1>hello world</h1>

<div align="center">
    <h1>Register form</h1>
    <form action="<%= request.getContextPath()%>/register" method="post">
        <table style="with: 80%">
            <tr>
                <td>Firstname</td>
                <td><input type="text" name="firstname"></td>
            </tr>
            <tr>
                <td>Lastname</td>
                <td><input type="text" name="lastname"></td>
            </tr>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td>PrePassword</td>
                <td><input type="text" name="prePassword"></td>
            </tr>
        </table>
        <input type="submit" value="Submit">
    </form>

</div>



</body>
</html>
