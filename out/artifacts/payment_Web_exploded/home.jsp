
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="uz.developers.model.User" %>
<%
//    HttpSession sessions = request.getSession(false);
//    String authUser = null;
//    if (sessions != null) {
//        authUser = (String) sessions.getAttribute("auth");
//    }
//    if (authUser == null) {
//        response.sendRedirect("login.jsp");
//    }
%>



<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">



    <title> Payment System </title>
    <style>
        body {
            background-image: url('images/backgounds/hero.png'); /* Rasmingiz manzilini yozing */
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

</head>
<body>

<%@include file="WEB-INF/jspf/navbar.jsp" %>
<div class="container">
    <div class="card-header my-3">Main page</div>

    <%@include file="WEB-INF/jspf/slidebar.jsp"%>

<%--    <h2>Welcome, <%= session.getAttribute("auth") %>!</h2>--%>
</div>






</body>
</html>
