package uz.developers.controller;

import uz.developers.model.Result;
import uz.developers.model.User;
import uz.developers.service.DbConnection;
import uz.developers.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {

    public UserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("userList.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF=8");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String  phone_number = req.getParameter("phone_number");
        String photo = req.getParameter("photo");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();


            UserService userService = new UserService(DbConnection.getConnection());
            User user = new User(firstname, lastname, email,phone_number,photo, password);
            Result result = userService.registerUser(user);
            if (result.isSuccess()){
                writer.write("<h1 color='green'>"+result.getMessage()+"</h1>");
                resp.sendRedirect("login.jsp");
            }else {
                writer.write("<h1 color='red'>"+result.getMessage()+"</h1>");
//                resp.sendRedirect("registration.jsp");
            }







    }
}
