






<%@ page import="uz.developers.service.DbConnection" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.developers.service.UserService" %>
<%@ page import="uz.developers.model.User" %>
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
            background-image: url('images/backgrounds/sky.jpg'); /* Rasmingiz manzilini yozing */
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

<form action="home.jsp">
    <input type="submit" value="Previous">
</form>
<div class="container">
    <form action="/client" method="get">
        <div class="row">
            <div class="col-md-3">
            </div>
            <div class="col-md-9">
                <h2>Clients List</h2>
                </hr>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Photo</th>
                        <th scope="col">Phone Number</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        UserService userService = new UserService(DbConnection.getConnection());
                        List<User> userList = userService.getAllClientList();
                        for (User user : userList) {
                    %>
                    <tr>
                        <th><%=user.getId()%></th>
                        <th><%=user.getFirstname()%></th>
                        <th><%=user.getLastname()%></th>
                        <th><img src="<%= user.getPhoto() %>" alt="Client Photo" width="50" height="50"></th>
                        <th><%=user.getPhone_number()%></th>

                        <td>
                            <a href="clientShow.jsp?id=<%=user.getId()%>" class="btn btn-primary">Show</a>
                            <a href="/clientEdit?id=<%=user.getId()%>" class="btn btn-light">Edit</a>
                            <a href="clientDelete.jsp?id=<%=user.getId()%>" class="btn btn-dark"
                               onclick="return confirm('Are you sure you want to delete this client?');">Delete</a>

                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </form>
</div>


</body>
</html>

