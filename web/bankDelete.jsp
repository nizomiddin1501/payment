
<%@ page import="uz.developers.service.DbConnection" %>
<%@ page import="uz.developers.service.BankService" %>

<%
//    User auth = (User) request.getSession().getAttribute("auth");
//    if (auth != null) {
//        request.setAttribute("auth", auth);
//    } else {
//        response.sendRedirect("login.jsp");
//    }
%>


<%
    int id = Integer.parseInt(request.getParameter("id"));
    BankService bankService = new BankService(DbConnection.getConnection());
    bankService.deleteBank(id);
    response.sendRedirect("bankList.jsp");
%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>



</body>
</html>
