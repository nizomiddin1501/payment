

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
</head>
<body>
<form action="bankList.jsp">
    <input type="submit" value="Previous">
</form>


<div class="container">


    <div class="row">
        <div class="col-md-9">
            <h2>New Car</h2>
            </hr>
            <form action="/bank" method="post">

                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" name="name" placeholder="Enter Bank Name">
                </div>

                <div class="form-group">
                    <label>Address</label>
                    <input type="text" class="form-control" name="address" placeholder="Enter Address">
                </div>

                <div class="form-group">
                    <label>Iban</label>
                    <input type="text" class="form-control" name="iban" placeholder="Enter Iban">
                </div>

                <div class="form-group">
                    <label>Photo</label>
                    <input type="file" class="form-control" name="photo" placeholder="Enter Photo url:">
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>


        </div>


    </div>
</div>


</body>
</html>
