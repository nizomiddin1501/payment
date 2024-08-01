package uz.developers.controller;

import uz.developers.model.Card;
import uz.developers.model.Order;
import uz.developers.service.BankService;
import uz.developers.service.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet("/orderNewCard")
public class NewCardServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bankId = Integer.parseInt(req.getParameter("bankId"));
        req.setAttribute("bankId", bankId);
        req.getRequestDispatcher("newCard.jsp").forward(req, resp);
    }

    BankService bankService = new BankService(DbConnection.getConnection());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String cardNumber = request.getParameter("cardNumber");
        String cardholderName = request.getParameter("cardholderName");
        Date expiryDate = Date.valueOf(request.getParameter("expiryDate")); // YYYY-MM-DD formatidagi sana
        Date issueDate = Date.valueOf(request.getParameter("issueDate")); // YYYY-MM-DD formatidagi sana
        String status = request.getParameter("status");
        BigDecimal balance = new BigDecimal(request.getParameter("balance"));
        String currency = request.getParameter("currency");
        String cardType = request.getParameter("cardType");
        String bankName = request.getParameter("bankName");

        // Order va Card obyektlarini yaratamiz
        Order order = new Order(userId);
        Card card = new Card(cardNumber,cardholderName, expiryDate, issueDate, status, balance, currency, userId, cardType, bankName);

        boolean isCardAdded = bankService.buyNewCard(order,card);

        if (isCardAdded) {
            response.sendRedirect("userList.jsp");
        } else {
            response.sendRedirect("bank.jsp");
        }
    }

}
