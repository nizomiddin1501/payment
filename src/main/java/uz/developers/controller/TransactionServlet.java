package uz.developers.controller;

import uz.developers.model.Account;
import uz.developers.service.DatabaseService;
import uz.developers.service.DbConnection;
import uz.developers.service.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transaction")
public class TransactionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account auth = (Account) request.getSession().getAttribute("auth");
        if (auth != null) {
            response.sendRedirect("transactions.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String phone_number = req.getParameter("phone_number");
        int balance = Integer.parseInt(req.getParameter("balance"));
        String card_number = req.getParameter("card_number");
        //DbService dbService = new DbService();
        DatabaseService databaseService = new DatabaseService(DbConnection.getConnection());

        Account account = new Account( username,phone_number,card_number,balance);
        databaseService.editAccount(account);
       // dbService.updateAccount(account);

        resp.sendRedirect("account-table.jsp");


    }
}
