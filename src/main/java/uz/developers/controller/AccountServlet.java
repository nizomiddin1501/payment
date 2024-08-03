package uz.developers.controller;

import uz.developers.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            User authUser = (User) session.getAttribute("auth");
            if (authUser != null) {
                req.setAttribute("user", authUser);
                req.getRequestDispatcher("  account.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("login.jsp");
            }
        } else {
            resp.sendRedirect("login.jsp");
        }
    }




}
