package uz.developers.controller;

import uz.developers.model.Account;
import uz.developers.service.DatabaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account auth = (Account) request.getSession().getAttribute("auth");
        if (auth != null) {
            response.sendRedirect("account_table.jsp");
        } else {
            response.sendRedirect("userLogin.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountId = req.getParameter("accountId");

        DatabaseService databaseService = new DatabaseService();
        databaseService.deleteAccount(Integer.parseInt(accountId));
        resp.sendRedirect("account_table.jsp");
    }






}
