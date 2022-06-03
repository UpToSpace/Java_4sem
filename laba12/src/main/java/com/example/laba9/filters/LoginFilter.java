package com.example.laba9.filters;

import com.example.laba9.classes.User;
import com.example.laba9.servlets.LoginServlet;
import com.example.laba9.servlets.RegistrationServlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(urlPatterns = "/home.jsp")
public class LoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("errorPage.jsp");
            } else
                chain.doFilter(servletRequest, servletResponse);
    }
}
