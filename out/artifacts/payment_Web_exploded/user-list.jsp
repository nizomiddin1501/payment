<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/29/2024
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>

    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <ul class="navbar-nav">
            <li><a href="<%request.getContextPath();%>/list"
                   class="nav-link">Accounts</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">List of Accounts</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Account</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Phone Number</th>
                <th>Balance</th>
                <th>Card Number</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${listAccount}">

                <tr>
                    <td><c:out value="${account.id}"/></td>
                    <td><c:out value="${account.username}"/></td>
                    <td><c:out value="${account.phone_number}"/></td>
                    <td><c:out value="${account.balance}"/></td>
                    <td><c:out value="${account.card_number}"/></td>
                    <td><a href="edit?id=<c:out value='${account.id}' /> ">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${account.id}' /> ">Delete</a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

</body>
</html>
