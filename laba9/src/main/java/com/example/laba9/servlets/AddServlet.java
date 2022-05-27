package com.example.laba9.servlets;

import com.example.laba9.classes.Database;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        try {
            Database database = new Database();
            database.AddGamer(number, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
