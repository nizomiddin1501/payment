<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/26/2024
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login User</title>
</head>
<body>


<div align="center">
  <h1>Login form</h1>
  <form action="<%= request.getContextPath()%>/login" method="post">
    <table style="with: 80%">
      <tr>
        <td>Username</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="text" name="password"></td>
      </tr>

    </table>
    <input type="submit" value="Login">
  </form>


</div>

</body>
</html>
