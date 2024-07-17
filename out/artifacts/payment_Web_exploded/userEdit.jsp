
<%@ page import="uz.developers.model.User" %>

<%
//    User auth = (User) request.getSession().getAttribute("auth");
//    if (auth != null) {
//        request.setAttribute("auth", auth);
//    } else {
//        response.sendRedirect("login.jsp");
//    }

%>

<%
    User user = (User) request.getAttribute("user");
    if (user == null) {
        out.println("No user found for editing.");
        return;
    }
%>


<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<form action="userList.jsp">
    <input  type="submit" value="Previous">
</form>

<div class="container">
    <h2>Edit Client</h2>
    <form action="/userEdit" method="post">
        <input type="hidden" name="id" value="<%= user.getId() %>">
        <div class="form-group">
            <label for="firstname">First Name :</label>
            <input type="text" class="form-control" id="firstname" name="firstname" value="<%= user.getFirstname() %>" required>
        </div>
        <div class="form-group">
            <label for="lastname">Last Name :</label>
            <input type="text" class="form-control" id="lastname" name="lastname" value="<%= user.getLastname() %>" required>
        </div>

        <div class="form-group">
            <label for="email">Email :</label>
            <input type="email" class="form-control" id="email" name="email" value="<%= user.getEmail() %>" required>
        </div>

        <div class="form-group">
            <label for="phone_number">Phone Number :</label>
            <input type="text" class="form-control" id="phone_number" name="phone_number" value="<%= user.getPhone_number() %>" required>
        </div>

        <div class="form-group">
            <label for="photo">Photo URL :</label>
            <input type="text" class="form-control" id="photo" name="photo" value="<%= user.getPhoto() %>" required>
        </div>

        <div class="form-group">
            <label for="password">Password :</label>
            <input type="password" class="form-control" id="password" name="password" value="<%= user.getPassword() %>" required>
        </div>



        <button type="submit" class="btn btn-primary">Edit</button>
    </form>
</div>


</body>
</html>
