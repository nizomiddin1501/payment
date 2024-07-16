package uz.developers.controller;

import uz.developers.model.Account;
import uz.developers.service.DbConnection;
import uz.developers.service.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Account auth = (Account) req.getSession().getAttribute("auth");
//        if (auth != null) {
//            resp.sendRedirect("account-table.jsp");
//        } else {
//            resp.sendRedirect("login.jsp");
//        }
//    }
        req.getRequestDispatcher("clientList.jsp").forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String phone_number = req.getParameter("phone_number");
        int balance = Integer.parseInt(req.getParameter("balance"));
        String card_number = req.getParameter("card_number");
        DbService dbService = new DbService(DbConnection.getConnection());
        Account account = new Account( username,phone_number,card_number,balance);
        dbService.addAccount(account);

        resp.sendRedirect("account-table.jsp");
    }


}
