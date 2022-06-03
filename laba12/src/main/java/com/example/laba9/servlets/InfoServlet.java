package com.example.laba9.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Enumeration;

@WebServlet(name = "InfoServlet", value = "/InfoServlet")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("Current date: " + LocalDate.now());
        pw.println("Protocol: " + request.getProtocol());
        pw.println("Client: "+ request.getRemoteAddr() + " his name: " + request.getRemoteUser());
        pw.println("Method: " + request.getMethod());
        pw.println("URL: " + request.getRequestURI());
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String element = headers.nextElement();
            pw.println(element + " = " + request.getHeader(element));
        }
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
