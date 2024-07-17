package uz.developers.controller;

import uz.developers.model.User;
import uz.developers.service.DbConnection;
import uz.developers.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userEdit")
public class UserEditServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserService userService = new UserService(DbConnection.getConnection());
        User existingUser = userService.getClientById(Integer.parseInt(id));
        if (existingUser != null) {
            req.setAttribute("user", existingUser);
            req.getRequestDispatcher("userEdit.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("userList.jsp"); // Redirect if the user is not found
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService(DbConnection.getConnection());
        int id = Integer.parseInt(req.getParameter("id"));
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String photo = req.getParameter("photo");
        String phone_number = req.getParameter("phone_number");

        User user = new User(id, firstname, lastname, email, password, photo, phone_number);
        userService.editUser(user);
        resp.sendRedirect("userList.jsp");
    }

}
