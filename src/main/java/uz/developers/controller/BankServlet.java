package uz.developers.controller;

import uz.developers.model.Bank;
import uz.developers.model.User;
import uz.developers.service.BankService;
import uz.developers.service.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bank")
public class BankServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User auth = (User) req.getSession().getAttribute("auth");
        if (auth != null) {
            resp.sendRedirect("car.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }
        req.getRequestDispatcher("bankList.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankService bankService = new BankService(DbConnection.getConnection());
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String iban = req.getParameter("iban");
        String photo = req.getParameter("photo");
        Bank bank = new Bank(name, address, iban, photo);

        bankService.addBank(bank);
        resp.sendRedirect("bankList.jsp");
        PrintWriter writer = resp.getWriter();
        writer.println("Bank added successfully!!!");


    }


}
