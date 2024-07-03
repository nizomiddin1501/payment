<%@ page import="uz.developers.service.DbService" %>
<%@ page import="uz.developers.model.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/3/2024
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    DbService dbService = new DbService();
    List<Account> accounts = dbService.getAccounts();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Bank Accounts</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<%--  Bismillahir Rohmanir Rohiym--%>

<div class="container">
    <div class="card-header my-3">All Accounts</div>
    <a href="account.jsp" style="float: right; margin: 10px 20px">
        <button class="btn btn-primary" style="padding: 2px 6px;">Add Account</button>
    </a>
    <table class="table table-light table-striped">
        <thead>

        <tr>
            <th scope="col">ID</th>
            <th scope="col">User Name</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Balance</th>
            <th scope="col">Card Number</th>
            <th scope="col">Type</th>
            <th scope="col" colspan="2">Action</th>
        </tr>
        </thead>

        <tbody>
            <%
            if (accounts != null) {
                for (Account account : accounts) {%>
        <tr>
            <td><%= account.getId()%>
            </td>
            <td id="user_name_<%=account.getId()%>"><%= account.getUsername()%>
            </td>
            <td id="phone_number_<%=account.getId()%>"><%= account.getPhone_number()%>
            </td>
            <td id="balance_<%=account.getId()%>"><%= account.getBalance()%>
            </td>
            <td id="card_number_<%=account.getId()%>"><%= account.getCard_number()%>
            </td>



            <td>
                <a href='#' style='margin:0 10px'>
                    <%--changing--%><button onclick='withdraw(<%= account.getCard_number()%>,<%= account.getBalance()%>)' type='button'
                            class='btn btn-outline-success  waves-effect'>Transfer
                    </button>
                </a>
            </td>


            <td>
                <a class="btn btn-sm btn-warning" href="#" type='button' onclick='editAccount(<%= account.getId()%>)'> <i
                        class="fa-solid fa-pen-to-square"></i> </a>
                <a class="btn btn-sm btn-danger" href="#" type='button' onclick='deleteAccount(<%= account.getId()%>)'><i
                        class="fa fa-trash" aria-hidden="true"></i></a>
            </td>

        </tr>

                <%
                }
            }
        %>

        </tbody>
    </table>
</div>


<div id="deleteModal" class="modal"
     style="width: 500px; height: 600px; margin-top: 200px;margin-left: 430px; text-align: center">
    <span onclick="document.getElementById('deleteModal').style.display='none'" class="close" title="Close Modal">&times;</span>
    <form class="modal-content" action="/delete" method="post">
        <div class="container">
            <h1>Delete Account</h1>
            <p>Are you sure you want to delete this account?</p>
            <div class="clearfix">
                <input type="hidden" id="clientId" name="clientId">
                <button type="button" style="margin: 10px 20px; width: 100px" class="btn btn-success"
                        onclick="document.getElementById('deleteModal').style.display='none'"  id="no">Cancel
                </button>
                <button type="button" style="margin: 10px 20px; width: 100px" class="btn btn-danger"
                        onclick="saveCountry()" id="yes">Delete
                </button>
            </div>
        </div>
    </form>
</div>



<div id="editModal" class="modal" style="margin-top: 100px">
    <div class="container jumbotron">
        <span onclick="document.getElementById('editModal').style.display='none'" class="close" title="Close Modal">&times;</span>
        <h1 style="color: black">Updating</h1>
        <form action="/client" method="post">


            <div class="form-group row">
                <label class="col-sm-2 col-form-label">ID</label>
                <div class="col-sm-7">
                    <input readonly="readonly" type="text" class="form-control" id="id" name="id"
                           placeholder="Enter first name">
                </div>
            </div>


            <div class="form-group row">
                <label class="col-sm-2 col-form-label">User Name</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="Enter user name">
                </div>
            </div>


            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Phone Number</label>
                <div class="col-sm-7">
                    <input type="number" class="form-control" id="phone_number" name="phone_number"
                           placeholder="Enter phone number">
                </div>
            </div>

            <div class=" form-group row">
                <label class="col-sm-2 col-form-label">Balance</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" id="balance" name="balance"
                           placeholder="Enter balance">
                </div>
            </div>

            <div class=" form-group row">
                <label class="col-sm-2 col-form-label">Card Number</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" id="card_number" name="card_number"
                           placeholder="Enter card number">
                </div>
            </div>

            <button type="submit" id="edit" class="btn btn-primary" style="float: right">Edit Account</button>
        </form>
    </div>
</div>



<div id="depositModal" class="modal" style="margin-top: 50px">
    <div class="container jumbotron" style="border: black">
        <span onclick="document.getElementById('depositModal').style.display='none'" class="close" title="Close Modal">&times;</span>
        <h1 style="color: black">DEPOSIT</h1>
        <div class="card bg-transparent">
            <div class="card-body">
                <form action="/deposit" method="post">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">From Whom</label>
                        <div class="col-sm-7">
                            <input readonly="readonly" type="text" class="form-control" id="depositId" name="deposit"
                                   placeholder="Enter first id">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">To Whom</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="toDepositId" name="toDeposit"
                                   placeholder="Enter second id">
                        </div>
                    </div>
                    <div class=" form-group row">
                        <label class="col-sm-2 col-form-label">Amount</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="amount" name="amount"
                                   placeholder="Enter amount">
                        </div>
                    </div>
                    <div class=" form-group row">
                        <label class="col-sm-2 col-form-label">Your Balance</label>
                        <div class="col-sm-7">
                            <input readonly="readonly" type="text" id="depositBalance" class="form-control"
                                   name="depositBalance"
                                   placeholder="Your Balance">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary" style="float: right">Send</button>
                </form>
            </div>
        </div>
    </div>
</div>





<div id="withdrawModal" class="modal" style="margin-top: 50px">
    <div class="container jumbotron">
        <span onclick="document.getElementById('withdrawModal').style.display='none'" class="close" title="Close Modal">&times;</span>
        <h1 style="color: black">Transaction</h1>
        <div class="card bg-transparent">
            <div class="card-body">
                <form action="/withdraw" method="post">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">To Whom</label>
                        <div class="col-sm-7">
                            <input type="text" readonly="readonly" class="form-control" id="senderCardNumber"
                                   name="senderCardNumber"
                                   placeholder="Enter sender card number">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">From Whom</label>
                        <div class="col-sm-7">
                            <input type="number" class="form-control" name="receiverCardNumber"
                                   placeholder="Enter receiver card number">
                        </div>
                    </div>

                    <div class=" form-group row">
                        <label class="col-sm-2 col-form-label">Amount</label>
                        <div class="col-sm-7">
                            <input type="number" class="form-control" name="amount"
                                   placeholder="Enter amount">
                        </div>
                    </div>

                    <div class=" form-group row">
                        <label class="col-sm-2 col-form-label">Your Balance</label>
                        <div class="col-sm-7">
                            <input readonly="readonly" type="text" id="withdraw" class="form-control"
                                   name="clientBalance"
                                   placeholder="Your Balance">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary" style="float: right">Send</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
<script>

    function saveCountry() {
        document.getElementById("saveButton").type = 'submit';
        document.getElementById("no").type = 'submit';
    }

    function editAccount(id) {
        document.getElementById('editModal').style.display = 'block';
        var username = document.getElementById('user_name_' + id).textContent;
        var phone_number = document.getElementById('phone_number_' + id).textContent;
        var balance = document.getElementById('balance_' + id).textContent;
        var card_number = document.getElementById('card_number_'+id).textContent;


        document.getElementById('id').value = id;
        document.getElementById('username').value = username;
        document.getElementById('phone_number').value = phone_number;
        // $("#iddropdown").dropdown('set selected', ['fruits']);
        document.getElementById('balance').value = balance;
        document.getElementById('card_number').value = card_number;

    }

    function getName(id){

    }

    function deleteAccount(id) {
        console.log(id);
        document.getElementById('deleteModal').style.display = 'block';
        document.getElementById("clientId").value = id;
        document.getElementById("yes").type = 'submit';
    }

    function deposit(id) {
        document.getElementById('depositModal').style.display = 'block';
        var depositBalance = document.getElementById(id).textContent;
        var depositBalance = document.getElementById('balance_' + id).textContent;
        document.getElementById('depositId').value = id;
        document.getElementById('depositBalance').value = depositBalance;
    }
// changing
    function withdraw(card_number, balance) {
        document.getElementById('withdrawModal').style.display = 'block';
        document.getElementById('senderCardNumber').value = id;
        document.getElementById('withdraw').value = balance;


    }
</script>




































</body>
</html>
