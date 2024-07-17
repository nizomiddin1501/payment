<%@ page import="uz.developers.service.DbConnection" %>
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

<%
    int clientId = Integer.parseInt(request.getParameter("id"));
    UserService userService = new UserService(DbConnection.getConnection());
    User userById = userService.getClientById(clientId);
%>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style>
        body {
            background-image: url('images/backgounds/style1.jpeg'); /* Rasmingiz manzilini yozing */
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

    <title style="text-align: center">Client Details</title>

</head>
<body>


            <section class="w-100 px-4 py-5" >
<%--                style="background-color: #9de2ff; border-radius: .5rem .5rem 0 0;"--%>
                <div class="row d-flex justify-content-center">
                    <div class="col col-md-9 col-lg-7 col-xl-6">
                        <div class="card" style="border-radius: 15px;">
                            <div class="card-body p-4">
                                <div class="d-flex">
                                    <div class="flex-shrink-0">
                                        <img src="<%= request.getContextPath() %>/<%= userById.getPhoto() %>" alt="Client Photo"
                                             class="img-fluid" style="width: 150px; border-radius: 50px;">
                                    </div>
                                    <div class="flex-grow-1 ms-3">
                                        <div class="container">
                                            <ul>
                                                <li><h5 class="mb-2"><%= userById.getFirstname() %></h5></li>
                                                <li><h5 class="mb-1"><%= userById.getLastname() %></h5></li>
                                                <li><h5 class="mb-1"><%= userById.getEmail() %></h5></li>
                                                <li><h5 class="mb-1"><%= userById.getPhone_number() %></h5></li>
                                                <li><h5 class="mb-1"><%= userById.getPassword() %></h5></li>

                                            </ul>
                                        </div>

                                        <div class="d-flex justify-content-center pt-1">
                                            <a href="userList.jsp?id=<%=userById.getId()%>" class="btn btn-primary">Previous</a>
                                            <a href="home.jsp?id=<%=userById.getId()%>" class="btn btn-light">Home</a>
<%--                                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary me-1 flex-grow-1">Chat</button>--%>
<%--                                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary flex-grow-1">Follow</button>--%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>





</body>
</html>
