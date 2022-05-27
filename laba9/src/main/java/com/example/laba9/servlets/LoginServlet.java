package com.example.laba9.servlets;

import com.example.laba9.classes.User;
import com.example.laba9.classes.Validation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        try {
            Validation validation = new Validation();
            HttpSession httpSession = request.getSession();
        if (validation.CheckLogin(email, pass)) {
            User user = new User(email, pass, validation.getRole());
            httpSession.setAttribute("user", user);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            httpSession.setAttribute("message", "The values are incorrect!");
            response.sendRedirect("login.jsp");
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
}
