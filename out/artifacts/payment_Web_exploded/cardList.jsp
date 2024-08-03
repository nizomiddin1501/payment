<%@ page import="java.sql.Connection" %>
<%@ page import="uz.developers.service.DbConnection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.developers.model.User" %>
<%@ page import="uz.developers.service.BankService" %>
<%@ page import="uz.developers.model.Bank" %>
<%@ page import="uz.developers.service.CardService" %>
<%@ page import="uz.developers.model.Card" %><%--
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

    <title>Card List</title>
</head>
<body>

<form action="home.jsp">
    <input  type="submit" value="Previous">
</form>



<div class="container">
    <form action="/card" method="get">
    <div class="row">
        <div class="col-md-9">
            <h2>Card List</h2>
            </hr>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Card Type</th>
                    <th scope="col">Bank Name</th>
                    <th scope="col">Card Number</th>
                    <th scope="col">Cardholder</th>
                    <th scope="col">Expiry Date</th>
                    <th scope="col">Status</th>
                    <th scope="col">Balance</th>
                </tr>
                </thead>
                <tbody>
                <%
                    CardService cardService = new CardService(DbConnection.getConnection());
                    List<Card> allCardList = cardService.getAllCardList();
                    for (Card card : allCardList) {
                %>
                <tr>
                    <th><%=card.getId()%></th>
                    <th><%=card.getCard_type()%></th>
                    <th><%=card.getBank_name()%></th>
                    <th><%=card.getCard_number()%></th>
                    <th><%=card.getCardholder_name()%></th>
                    <th><%=card.getExpiry_date()%></th>
                    <th><%=card.getStatus()%></th>
                    <th><%=card.getBalance()%></th>
<%--                    <th><img src="<%= card.getPhoto() %>" alt="Car Photo" width="50" height="30"></th>--%>
                    <td>

                        <a href="cardShow.jsp?id=<%=card.getId()%>" class="btn btn-primary">Show</a>
                        <a href="/cardEdit?id=<%=card.getId()%>" class="btn btn-light">Edit</a>
                        <a href="/orderNewCard?bankId=<%=card.getId()%>" class="btn btn-light">Card</a>
                        <a href="cardDelete.jsp?id=<%=card.getId()%>" class="btn btn-dark"
                           onclick="return confirm('Are you sure you want to delete this car?');">Delete</a>
                    </td>
                </tr>
                <%}%>
                </tbody>

            </table>
        </div>
    </div>
<%--        <button type="submit" class="btn btn-primary" style="float: right">Add Car</button>--%>
        <a href="card.jsp?id=" class="btn btn-success">Add Card</a>

    </form>
</div>





</body>
</html>
