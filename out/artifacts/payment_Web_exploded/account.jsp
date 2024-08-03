<%@ page import="java.text.DecimalFormat" %>
<%@ page import="uz.developers.model.Account" %>
<%@ page import="uz.developers.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  HttpSession sessions = request.getSession(false);
  User user = (User) request.getAttribute("user");


%>

<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Account</title>

</head>
<body>



<%@include file="WEB-INF/jspf/navbar.jsp" %>
<div class="container mt-5">
  <h2>Account Information</h2>

  <div class="container">
    <h2>Account Information</h2>
    <p><strong>FirstName:</strong> <%= user.getFirstname() %></p>
    <p><strong>Lastname:</strong> <%= user.getLastname() %></p>
    <p><strong>Email:</strong> <%= user.getEmail() %></p>
    <p><strong>Phone Number:</strong> <%= user.getPhone_number() %></p>
    <p><strong>Photo:</strong> <img src="<%= user.getPhoto() %>" alt="Profile Picture" class="rounded-circle" style="width: 100px; height: 100px;"></p>
    <p><strong>Password:</strong> <%= user.getPassword() %></p>
  </div>

  <table class="table">
    <tr>
      <th>Fistname:</th>
      <td><%= user.getFirstname() %></td>
    </tr>

    <tr>
      <th>Lastname:</th>
      <td><%= user.getLastname() %></td>
    </tr>

    <tr>
      <th>Email:</th>
      <td><%= user.getEmail() %></td>
    </tr>

    <tr>
      <th>Phone Number:</th>
      <td><%= user.getPhone_number() %></td>
    </tr>

    <tr>
      <th>Photo:</th>
      <td><%= user.getPhoto() %></td>
    </tr>

    <tr>
      <th>Password:</th>
      <td><%= user.getPassword()%></td>
    </tr>



  </table>
</div>





</body>
</html>
