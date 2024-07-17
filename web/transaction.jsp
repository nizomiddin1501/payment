<%@ page import="uz.developers.service.DatabaseService" %>
<%@ page import="uz.developers.model.Transactions" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.developers.service.DbConnection" %>
<%@ page import="uz.developers.service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/3/2024
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<%@include file="WEB-INF/jspf/header.jsp" %>
<head>
    <title>All Transactions</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<%@include file="WEB-INF/jspf/navbar.jsp" %>
<body>
















<h3 style="text-align: center">All Transacion</h3>
<div class="container-fluid" style="margin-top: 10px">
    <table class="table table-bordered table-hover table-striped" border="1" cellpadding="10" id="transactions">
        <thead class="thead-dark">
        <tr>
            <th>Tr</th>
            <th>ID</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Sender Card</th>
            <th>Receiver Card</th>
        </tr>
        </thead>
        <tbody>



        <%
            UserService userService = new UserService(DbConnection.getConnection());
            List<Transactions> transactions = userService.getAllTransactions();
            for (int i = 0; i < transactions.size(); i++) {
                out.print(
                        "<tr>" +
                                "<td>" + (i + 1) + "</td>" +
                                "<td>" + transactions.get(i).getId() + "</td>" +
                                "<td id='amount_" + transactions.get(i).getId() + "'>$" + (transactions.get(i).getAmount()) + "</td>" +
                                "<td id='date_" + transactions.get(i).getId() + "'>" + (transactions.get(i).getDate()) + "</td>" +
                                "<td id='from_" + transactions.get(i).getId() + "'>" + (transactions.get(i).getSender_card_number()) + "</td>" +
                                "<td id='to_" + transactions.get(i).getId() + "'>" + (transactions.get(i).getReceiver_card_number()) + "</td>" +
                                "<tr>"
                );
            }
        %>
        </tbody>
    </table>
</div>
<%@include file="includes/footer.jsp" %>








</body>
</html>
