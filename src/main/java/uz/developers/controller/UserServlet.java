package uz.developers.controller;

import uz.developers.model.Result;
import uz.developers.model.User;
import uz.developers.service.DatabaseService;
import uz.developers.service.DbConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/register")
public class UserServlet extends HttpServlet {

    public UserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("registration.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF=8");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String prePassword = req.getParameter("prePassword");

        PrintWriter writer = resp.getWriter();

        if (password.equals(prePassword)){
            DatabaseService databaseService = new DatabaseService(DbConnection.getConnection());
            User user = new User(firstname, lastname, username, password);
            Result result = databaseService.registerUser(user);
            if (result.isSuccess()){
                writer.write("<h1 color='green'>"+result.getMessage()+"</h1>");
                resp.sendRedirect("login.jsp");
            }else {
                writer.write("<h1 color='red'>"+result.getMessage()+"</h1>");
                resp.sendRedirect("registration.jsp");
            }
        }






    }
}
