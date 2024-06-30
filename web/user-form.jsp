<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 6/29/2024
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="http://www.javaguides.net" class="navbar-brand"> User Management App</a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%request.getContextPath();%>/list"
                   class="nav-link">Accounts</a></li>
        </ul>

        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li><a href="<%=request.getContextPath()%>/logout"
                   class="nav-link">Logout</a></li>
        </ul>

    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${account!=null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${account==null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${account!=null}">
                                Edit Account
                            </c:if>
                            <c:if test="${account==null}">
                                Add New Account
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${account!=null}">
                    <input type="hidden" name="id" value="<c:out value='${account.id}'/>"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Username</label> <input type="text"
                                                       value="<c:out value='${account.username}'/>" class="form-control"
                                                       name="username" required="required" minlength="5">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Phone Number</label> <input type="text"
                                                       value="<c:out value='${account.phone_number}'/>" class="form-control"
                                                       name="phone_number" required="required" >
                    </fieldset>

                        <fieldset class="form-group">
                            <label>Balance</label> <input type="text"
                                                           value="<c:out value='${account.balance}'/>"class="form-control"
                                                           name="balance" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Card Number</label> <input type="text"
                                                           value="<c:out value='${account.card_number}'/>"class="form-control"
                                                           name="card_number" required="required">
                        </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>

    </div>

</div>

</body>
</html>
