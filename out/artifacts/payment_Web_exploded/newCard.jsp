

<%@ page import="uz.developers.model.User" %>
<%@ page import="uz.developers.model.Bank" %>
<%
    //    User auth = (User) request.getSession().getAttribute("auth");
//    if (auth != null) {
//        request.setAttribute("auth", auth);
//    } else {
//        response.sendRedirect("login.jsp");
//    }

//    Bank bank = (Bank) request.getAttribute("bank");
//    if (bank == null) {
//        out.println("No bank found for order new card.");
//        return;
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
            <h2>New Card</h2>
            </hr>
            <form action="/orderNewCard" method="post">

                <input type="hidden" name="bankId" value="${bankId}">

                <div class="form-group">
                    <label>User ID</label>
                    <input type="text" class="form-control" name="userId" placeholder="Enter User ID">
                </div>

                <div class="form-group">
                    <label>Card Number</label>
                    <input type="text" class="form-control" name="card_number" placeholder="Enter Card Number">
                </div>

                <div class="form-group">
                    <label>Card Holder</label>
                    <input type="text" class="form-control" name="cardholder_name" placeholder="Enter Cardholder name">
                </div>

                <div class="form-group">
                    <label>Expiry Date</label>
                    <input type="date" class="form-control" name="expiry_date" placeholder="Enter Expiry Date">
                </div>

                <div class="form-group">
                    <label>Issue Date</label>
                    <input type="date" class="form-control" name="issue_date" placeholder="Enter Issue Date">
                </div>


                <div class="form-group">
                    <label>Status</label>
                    <select id="status" name="status" required>
                        <option value="Active">Active</option>
                        <option value="Inactive">Inactive</option>
                        <option value="Blocked">Blocked</option>
                        <option value="Expired">Expired</option>
                        <option value="Lost">Lost</option>
                        <option value="Stolen">Stolen</option>
                        <option value="Pending">Pending</option>
                        <option value="Closed">Closed</option>
                    </select>
                </div>



                <div class="form-group">
                    <label>Card Type</label>
                    <select id="cardType" name="cardType" required>
                        <option value="UZCARD">UZCARD</option>
                        <option value="HUMO">HUMO</option>
                        <option value="VISA">VISA</option>
                        <option value="MASTERCARD">MASTERCARD</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>Balance</label>
                    <input type="number" class="form-control" name="balance" placeholder="Enter Balance">
                </div>

                <div class="form-group">
                    <label>Currency</label>
                    <select id="currency" name="currency" required>
                        <option value="UZS">UZS</option>
                        <option value="USD">USD</option>
                        <option value="EUR">EUR</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>Bank Name</label>
                    <input type="text" class="form-control" name="bank_name" placeholder="Enter Bank Name">
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>


        </div>


    </div>
</div>


</body>
</html>
