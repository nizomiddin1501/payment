package uz.developers.controller;


import uz.developers.service.DatabaseService;
import uz.developers.service.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String senderCardNumber = req.getParameter("senderCardNumber");
        String receiverCardNumber = req.getParameter("receiverCardNumber");
        int amount = Integer.parseInt(req.getParameter("amount"));

        DatabaseService databaseService = new DatabaseService(DbConnection.getConnection());
        databaseService.transfer(senderCardNumber,receiverCardNumber,amount);
        resp.sendRedirect("account-table.jsp");





    }
}
