package com.example.laba9.servlets;

import com.example.laba9.classes.Validation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Validation validation = new Validation();
        try {
            if (validation.AddNewUser(email, pass)) {
                response.sendRedirect("login.jsp");
            } else {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("rmessage", "This user already exists or fields are empty");
                response.sendRedirect("registration.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
