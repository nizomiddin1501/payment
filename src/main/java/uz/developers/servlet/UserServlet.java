package uz.developers.servlet;

import uz.developers.model.User;
import uz.developers.service.DatabaseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/register")
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/web/views/userRegister.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User user = new User(firstname,lastname,username,password);
        DatabaseService databaseService = new DatabaseService();
        databaseService.registerUser(user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/web/views/userDetails.jsp");
        dispatcher.forward(req,resp);




    }
}
