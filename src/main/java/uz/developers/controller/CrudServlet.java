package uz.developers.controller;

import uz.developers.model.Account;
import uz.developers.model.User;
import uz.developers.service.DatabaseService;
import uz.developers.service.DbService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/crud")
public class CrudServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;
    private DbService dbService;

    public CrudServlet(){
        this.dbService = new DbService();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();

        switch (action){
            case "/new":
                showNewForm(req,resp);
                break;
            case "/insert":
                insertAccount(req,resp);
                break;
            case "/delete":
                deleteAccount(req,resp);
                break;
            case "/edit":
                showEditForm(req,resp);
                break;
            case "/update":
                updateAccount(req,resp);
                break;
            case "/list":
                try {
                    listAccount(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                RequestDispatcher dispatcher = req.getRequestDispatcher("login/userLogin.jsp");
                dispatcher.forward(req, resp);
                break;
        }
    }

    private void listAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Account> listAccount = dbService.getAccounts();
        req.setAttribute("listAccount",listAccount);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(req,resp);
    }

    private void updateAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        String username = req.getParameter("username");
        String phone_number = req.getParameter("phone_number");
        String card_number = req.getParameter("card_number");
        int balance = Integer.parseInt(req.getParameter("balance"));

        Account account = new Account(id,username,phone_number,card_number,balance);
        dbService.updateAccount(account);
        resp.sendRedirect("list");  //

    }

    private void deleteAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dbService.deleteAccount(id);
        resp.sendRedirect("list");  //
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Account existingAccount = dbService.getAccount(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user-form.jsp");
        req.setAttribute("account",existingAccount);
        dispatcher.forward(req,resp);  //
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(req,resp); //
    }

    private void insertAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String phone_number = req.getParameter("phone_number");
        String card_number = req.getParameter("card_number");
        int balance = Integer.parseInt(req.getParameter("balance"));

        Account account = new Account(username,phone_number,card_number,balance);
        dbService.addAccount(account);
        resp.sendRedirect("list");  //

    }


}
