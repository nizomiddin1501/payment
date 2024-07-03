<%@ page import="uz.developers.service.DatabaseService" %>
<%@ page import="uz.developers.model.Transactions" %>
<%@ page import="java.util.List" %><%--
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
<%@include file="includes/head.jsp" %>
<head>
    <title>All Transactions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
</head>
<%@include file="includes/navbar.jsp" %>
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
            DatabaseService databaseService = new DatabaseService();
            List<Transactions> transactions = databaseService.getAllTransactions();
            for (int i = 0; i < transactions.size(); i++) {
                out.print(
                        "<tr>" +
                                "<td>" + (i + 1) + "</td>" +
                                "<td>" + transactions.get(i).getId() + "</td>" +
                                "<td id='amount_" + transactions.get(i).getId() + "'>$" + (transactions.get(i).getAmount()) + "</td>" +
                                "<td id='date_" + transactions.get(i).getId() + "'>" + (transactions.get(i).getDate()) + "</td>" +
                                "<td id='from_" + transactions.get(i).getId() + "'>" + (transactions.get(i).getSenderCardNumber()) + "</td>" +
                                "<td id='to_" + transactions.get(i).getId() + "'>" + (transactions.get(i).getReceiverCardNumber()) + "</td>" +
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
