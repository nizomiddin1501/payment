<%@ page import="java.sql.Connection" %>
<%@ page import="uz.developers.service.DbConnection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.developers.model.User" %>
<%@ page import="uz.developers.service.BankService" %>
<%@ page import="uz.developers.model.Bank" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/9/2024
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
//    User auth = (User) request.getSession().getAttribute("auth");
//    if (auth != null) {
//        request.setAttribute("auth", auth);
//    } else {
//        response.sendRedirect("login.jsp");
//    }
%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style>
        body {
            background-image: url('images/banks/zor.jpg'); /* Rasmingiz manzilini yozing */
            background-size: cover; /* Rasmni ekranga to'liq moslashtirish */
            background-position: center; /* Rasmni markazga joylashtirish */
            background-repeat: no-repeat; /* Rasmni takrorlamaslik */
            margin: 0;
            font-family: Arial, sans-serif;
        }
        h1 {
            color: white;
            text-align: center;
            padding-top: 20%;
        }
    </style>

    <title>Car List</title>
</head>
<body>

<form action="home.jsp">
    <input  type="submit" value="Previous">
</form>



<div class="container">
    <form action="/bank" method="get">
    <div class="row">
        <div class="col-md-9">
            <h2>Car List</h2>
            </hr>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Photo</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <%
                    BankService bankService = new BankService(DbConnection.getConnection());
                    List<Bank> allBankList = bankService.getAllBankList();
                    for (Bank bank : allBankList) {
                %>
                <tr>
                    <th><%=bank.getId()%></th>
                    <th><%=bank.getName()%></th>
                    <th><%=bank.getAddress()%></th>
                    <th><img src="<%= bank.getPhoto() %>" alt="Car Photo" width="50" height="30"></th>
                    <td>

                        <a href="bankShow.jsp?id=<%=bank.getId()%>" class="btn btn-primary">Show</a>
                        <a href="/bankEdit?id=<%=bank.getId()%>" class="btn btn-light">Edit</a>
                        <a href="/orderNewCard?bankId=<%=bank.getId()%>" class="btn btn-light">Card</a>
                        <a href="bankDelete.jsp?id=<%=bank.getId()%>" class="btn btn-dark"
                           onclick="return confirm('Are you sure you want to delete this car?');">Delete</a>
                    </td>
                </tr>
                <%}%>
                </tbody>

            </table>
        </div>
    </div>
<%--        <button type="submit" class="btn btn-primary" style="float: right">Add Car</button>--%>
        <a href="bank.jsp?id=" class="btn btn-success">Add Bank</a>

    </form>
</div>





</body>
</html>
