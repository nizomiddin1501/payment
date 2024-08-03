<%@ page import="uz.developers.model.User" %>
<%--<%--%>
<%--        User auth = (User) request.getSession().getAttribute("auth");--%>
<%--    if (auth != null) {--%>
<%--        request.setAttribute("auth", auth);--%>
<%--    } else {--%>
<%--        response.sendRedirect("login.jsp");--%>
<%--    }--%>
<%--%>--%>


<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">


    <div class="row">

        <div class="card-body">

            </hr>
            <form action="/login" method="post">
                <h2>Login</h2>


                <section class="vh-100">
                    <div class="container-fluid h-custom">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-md-9 col-lg-6 col-xl-5">
<%--                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"--%>
<%--                                     class="img-fluid" alt="Sample image">--%>
                                <img src="images/backgounds/kisspng.jpg"
                                     class="img-fluid" alt="Sample image">

                            </div>
                            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                                <form>
                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="exampleInputEmail">Email Address</label>
                                        <input type="email" class="form-control form-control-lg" name="email"
                                               id="exampleInputEmail" itemid="exampleInputEmail"
                                               placeholder="Enter Email Address" required/>

                                    </div>



                                    <div data-mdb-input-init class="form-outline mb-3">
                                        <label class="form-label" for="exampleInputPassword">Password</label>
                                        <input type="password" class="form-control form-control-lg" name="password"
                                               id="exampleInputPassword" itemid="exampleInputPassword"
                                               placeholder="**************" required/>
                                    </div>

                                    <div class="d-flex justify-content-between align-items-center">

                                        <div class="form-check mb-0">
                                            <input class="form-check-input me-2" type="checkbox" value=""
                                                   id="form2Example3"/>
                                            <label class="form-check-label" for="form2Example3">Remember me</label>
                                        </div>
                                        <a href="#!" class="text-body">Forgot password?</a>
                                    </div>


                                    <div class="text-center text-lg-start mt-4 pt-2">
                                        <button type="submit" data-mdb-button-init data-mdb-ripple-init
                                                class="btn btn-primary btn-lg"
                                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Login
                                        </button>
                                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a
                                                href="/register?id=" class="link-danger">Register</a></p>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>

                </section>


            </form>
        </div>
    </div>
</div>
</body>
</html>
