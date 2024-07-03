<%@ page import="java.text.DecimalFormat" %>
<%@ page import="uz.developers.model.Account" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/3/2024
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  DecimalFormat decimalFormat = new DecimalFormat("#.##");
  request.setAttribute("decimalFormat", decimalFormat);
  Account auth = (Account) request.getSession().getAttribute("auth");
  if (auth != null) {
    request.setAttribute("auth", auth);
  }

%>

<html>
<head>
    <title>Account</title>
  <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<style type="text/css">
  .table tbody td {
    vertical-align: middle;
  }

  .btn-incre, .btn-decre {
    box-shadow: none;
    font-size: 25px;
  }
</style>

<div class="container">

  <form action="/client" method="post">
    <div class="form-group row">
      <label class="col-sm-2 col-form-label">Username</label>
      <div class="col-sm-7">
        <input type="text" class="form-control" name="username"
               placeholder="Enter username" required>
      </div>
    </div>



    <div class="form-group row">
      <label class="col-sm-2 col-form-label">Phone Number</label>
      <div class="col-sm-7">
        <input type="number" class="form-control" name="phone_number"
               placeholder="Enter phone number" required>
      </div>
    </div>

    <div class=" form-group row">
      <label class="col-sm-2 col-form-label">Balance</label>
      <div class="col-sm-7">
        <input type="number" class="form-control" name="balance"
               placeholder="Enter balance" required>
      </div>
    </div>

    <div class="form-group row">
      <label class="col-sm-2 col-form-label">Card Number</label>
      <div class="col-sm-7">
        <input type="text" class="form-control" name="card_number"
               placeholder="Enter card number" required>
      </div>
    </div>

    <button type="submit" class="btn btn-primary" style="float: right">Add Account</button>
  </form>
</div>
<%@include file="includes/footer.jsp" %>


</body>
</html>
