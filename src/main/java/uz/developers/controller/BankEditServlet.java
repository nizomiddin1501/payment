package uz.developers.controller;

import uz.developers.model.Bank;
import uz.developers.service.BankService;
import uz.developers.service.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bankEdit")
public class BankEditServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        BankService bankService = new BankService(DbConnection.getConnection());
        Bank existingBank = bankService.getBankById(Integer.parseInt(id));
        if (existingBank != null) {
            req.setAttribute("bank", existingBank);
            req.getRequestDispatcher("bankEdit.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("bankList.jsp");
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankService bankService = new BankService(DbConnection.getConnection());
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String iban = req.getParameter("iban");
        String photo = req.getParameter("photo");


        Bank bank = new Bank(id,name,address,iban,photo);
        bankService.updateBank(bank);
        resp.sendRedirect("bankList.jsp");
    }

}
