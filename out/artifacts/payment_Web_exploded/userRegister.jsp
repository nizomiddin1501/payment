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
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<%--<h1>hello world</h1>--%>

<%--<div align="center">--%>
<%--    <h1>Register form</h1>--%>
<%--    <form action="<%= request.getContextPath()%>/register" method="post">--%>
<%--        <table style="with: 80%">--%>
<%--            <tr>--%>
<%--                <td>Firstname</td>--%>
<%--                <td><input type="text" name="firstname"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Lastname</td>--%>
<%--                <td><input type="text" name="lastname"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Username</td>--%>
<%--                <td><input type="text" name="username"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Password</td>--%>
<%--                <td><input type="text" name="password"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>PrePassword</td>--%>
<%--                <td><input type="text" name="prePassword"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--        <input type="submit" value="Submit">--%>
<%--    </form>--%>
<%--</div>--%>


<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">User Register</div>
        <div class="card-body">
            <form action="/register" method="post">
                <div class="form-group">
                    <label for="">Firstname</label>
                    <input type="name" class="form-control" name="firstname" placeholder="Enter your  firstname" required>
                </div>

                <div class="form-group">
                    <label for="">Lastname</label>
                    <input type="name" class="form-control" name="lastname" placeholder="Enter your  lastname" required>
                </div>
                <div class="form-group">
                    <label for="">Username</label>
                    <input type="name" class="form-control" name="username" placeholder="Enter your  username" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" name="password" placeholder="********" required>
                </div>

                <div class="form-group">
                    <label>PrePassword</label>
                    <input type="password" class="form-control" name="prePassword" placeholder="********" required>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>



</body>
</html>
