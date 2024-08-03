
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession sessions = request.getSession(false);
    User authUser = null;
    if (sessions != null) {
        authUser = (User) sessions.getAttribute("auth");
    }
//    if (authUser == null) {
//        response.sendRedirect("login.jsp");
//    }

    User user = new User();
%>

<style>
    .nav-link img.rounded-circle {
        border-radius: 50%;
    }
</style>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="../home.jsp">Payment-System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="home.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="/user">Clients</a></li>
                <li class="nav-item"><a class="nav-link" href="/card">Cards</a></li>
                <li class="nav-item"><a class="nav-link" href="/bank">Bank</a></li>
                <li class="nav-item"><a class="nav-link" href="/register">Transfer</a></li>
                <li class="nav-item"><a class="nav-link" href="/transaction">Transactions</a></li>
                <li class="nav-item"><a class="nav-link" href="/"></a></li>

<%--                    <% if (authUser != null) { %>--%>
                <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
<%--                    <% } else { %>--%>
                <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
<%--                    <% } %>--%>
                <li class="nav-item">
<%--                    <a class="nav-link" href="/account.jsp">Account</a>--%>

                    <a class="nav-link" href="/account ">
                        <img src="<%= authUser.getPhoto() %>" alt="Profile Picture" class="rounded-circle" style="width: 30px; height: 30px;">
                        <span><%= authUser.getFirstname() %></span>
                    </a>

                </li>


<%--                <li class="nav-item"><a class="nav-link" href="/login">Log out</a></li>--%>


        </div>
    </div>
</nav>