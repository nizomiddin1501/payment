
<%@ page import="java.util.List" %>
<%@ page import="uz.developers.model.User" %>
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




    Bank bank = (Bank) request.getAttribute("bank");
    if (bank == null) {
        out.println("No bank found for editing.");
        return;
    }


%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Car List</title>
</head>
<body>

<form action="bankList.jsp">
    <input  type="submit" value="Previous">
</form>



<div class="container">
    <h2>Edit Car</h2>
    <form action="/bankEdit" method="post">
        <input type="hidden" name="id" value="<%= bank.getId() %>">
        <div class="form-group">
            <label for="name">Bank Name</label>
            <input type="text" class="form-control" id="name" name="name" value="<%=bank.getName()%>" required>
        </div>
        <div class="form-group">
            <label for="address">Bank Address</label>
            <input type="text" class="form-control" id="address" name="address" value="<%=bank.getAddress()%>" required>
        </div>

        <div class="form-group">
            <label for="iban">Bank Iban</label>
            <input type="text" class="form-control" id="iban" name="iban" value="<%=bank.getIban()%>" required>
        </div>

        <div class="form-group">
            <label for="photo">Bank Photo</label>
            <input type="file" class="form-control" id="photo" name="photo" value="<%=bank.getPhoto()%>" required>
        </div>


        <button type="submit" class="btn btn-primary">Save</button>
        <a href="bankList.jsp" class="btn btn-secondary">Cancel</a>
    </form>
</div>













</body>
</html>
