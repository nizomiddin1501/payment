<%@ page import="uz.developers.model.Account" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/26/2024
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Account auth = (Account) request.getSession().getAttribute("auth");
  request.getSession().removeAttribute("auth");
  if (auth != null) {
    response.sendRedirect("index.jsp");
  }
%>





<html>
<head>
    <title>Login User</title>

  <style>
    body {
      background-image: url( "2.jpg"); /* Path to your image */
      background-size: cover; /* Cover the entire page */
      background-repeat: no-repeat; /* Prevent the image from repeating */
      background-position: center; /* Center the image */
    }
  </style>


  <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>


<%--<div align="center">--%>
<%--  <h1>Login form</h1>--%>
<%--  <form action="<%= request.getContextPath()%>/login" method="post">--%>
<%--    <table style="with: 80%">--%>
<%--      <tr>--%>
<%--        <td>Username</td>--%>
<%--        <td><input type="text" name="username"></td>--%>
<%--      </tr>--%>
<%--      <tr>--%>
<%--        <td>Password</td>--%>
<%--        <td><input type="text" name="password"></td>--%>
<%--      </tr>--%>

<%--    </table>--%>
<%--    <input type="submit" value="Login">--%>
<%--  </form>--%>


<%--</div>--%>


<div class="container">

  <div class="card w-50 mx-auto my-5">
    <div class="card-header text-center">User login</div>
    <div class="card-body">
      <form action="login" method="post">
        <div class="form-group">
          <label for="">Username</label>
          <input type="name" class="form-control" name="username" placeholder="Enter your  username" required>
        </div>
        <div class="form-group">
          <label>Password</label>
          <input type="password" class="form-control" name="password" placeholder="********" required>
        </div>
        <div class="text-center">
          <button type="submit" class="btn btn-primary">Login</button>
        </div>
      </form>
    </div>
  </div>
</div>


<%@include file="includes/footer.jsp" %>
</body>
</html>
