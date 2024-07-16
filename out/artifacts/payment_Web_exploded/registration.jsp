<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">


    <div class="row">
        <div class="col-md-3">
        </div>

        <div class="col-md-9">
            </hr>
            <form action="/client" method="post">
                <h2>REGISTER</h2>
                <section class="vh-100">
                    <div class="container-fluid h-custom">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-md-9 col-lg-6 col-xl-5">
<%--                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"--%>
<%--                                     class="img-fluid" alt="Sample image">--%>

                                <img src="images/backgounds/reg.png" class="img-fluid" alt="Sample image">


                            </div>
                            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                                <form>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="exampleInputFirstname">Firstname</label>
                                        <input type="text" class="form-control form-control-lg" name="firstname" id="exampleInputFirstname" itemid="exampleInputEmail" placeholder="Enter firstname" required>
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="exampleInputLastname">Lastname</label>
                                        <input type="text" class="form-control form-control-lg" name="lastname" id="exampleInputLastname" itemid="exampleInputLastname" placeholder="Enter lastname" required>
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="exampleInputUsername">Username</label>
                                        <input type="number" class="form-control form-control-lg" name="phoneNumber" id="exampleInputUsername" itemid="exampleInputUsername" placeholder="Enter user name" required>
                                    </div>


                                    <div data-mdb-input-init class="form-outline mb-3">
                                        <label class="form-label" for="exampleInputPassword">Password</label>
                                        <input type="password" class="form-control form-control-lg" name="password"
                                               id="exampleInputPassword" itemid="exampleInputPassword"
                                               placeholder="**************" required/>
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-3">
                                        <label class="form-label" for="exampleInputPhoto">Photo</label>
                                        <input type="file" class="form-control form-control-lg" name="photo" id="exampleInputPhoto" itemid="exampleInputPhoto" placeholder="Upload photo" required/>
                                    </div>

                                    <div class="text-center text-lg-start mt-4 pt-2">
                                        <button type="submit" data-mdb-button-init data-mdb-ripple-init
                                                class="btn btn-primary btn-lg"
                                                style="padding-left: 2.5rem; padding-right: 2.5rem;">SIGN UP</button>

                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>

                </section>


                <%--                <div class="form-group">--%>
                <%--                    <label for="exampleInputFirstname">Firstname</label>--%>
                <%--                    <input type="text" class="form-control" name="firstname" id="exampleInputFirstname"  placeholder="Enter Firstname">--%>
                <%--                </div>--%>

                <%--                <div class="form-group">--%>
                <%--                    <label for="exampleInputLastname">Lastname</label>--%>
                <%--                    <input type="text" class="form-control" name="lastname" id="exampleInputLastname"  placeholder="Enter Lastname">--%>
                <%--                </div>--%>

                <%--                <div class="form-group">--%>
                <%--                    <label for="exampleInputPhoneNumber">Phone Number</label>--%>
                <%--                    <input type="number" class="form-control" name="phoneNumber" id="exampleInputPhoneNumber"  placeholder="Enter Phone Number">--%>
                <%--                </div>--%>


                <%--                <div class="form-group">--%>
                <%--                    <label for="exampleInputEmail1">Email address</label>--%>
                <%--                    <input type="email" class="form-control" name="email" id="exampleInputEmail1"  placeholder="Enter email">--%>
                <%--                </div>--%>

                <%--                <div class="form-group">--%>
                <%--                    <label for="exampleInputPassword1">Password</label>--%>
                <%--                    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">--%>
                <%--                </div>--%>

                <%--                <div class="form-group">--%>
                <%--                    <label for="exampleInputPhoto">Photo</label>--%>
                <%--                    <input type="file" class="form-control" name="photo" id="exampleInputPhoto" placeholder="Photo">--%>
                <%--                </div>--%>

                <%--                <button type="submit" class="btn btn-primary">Registration</button>--%>


            </form>


        </div>


    </div>
</div>


</body>
</html>
