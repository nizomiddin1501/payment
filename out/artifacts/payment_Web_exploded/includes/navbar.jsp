<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="../home.jsp">Payment System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="/home.jsp">Home</a></li>
                <%--                <li class="nav-item"><a class="nav-link" href="client.jsp">Cart <span--%>
                <%--                        class="badge badge-danger px-1">${cart_list.size()}</span></a></li>--%>
                <%--                <%if (auth != null) {%>--%>
                <li class="nav-item"><a class="nav-link" href="/client">Clients</a></li>
                <li class="nav-item"><a class="nav-link" href="bank">Banks</a></li>
                <li class="nav-item"><a class="nav-link" href="/transaction">Transaction</a></li>
                <%--                <%} else {%>--%>
                <li class="nav-item"><a class="nav-link" href="userLogin.jsp">Sign in</a></li>
                <li class="nav-item"><a class="nav-link" href="userRegister.jsp">Sign up</a></li>
                <li class="nav-item"><a class="nav-link" href="login.jsp">Log out</a></li>

        </div>
    </div>
</nav>