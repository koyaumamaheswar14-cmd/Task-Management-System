package com.taskmanager.controllers;

import com.taskmanager.dao.UserDAO;
import com.taskmanager.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 🔹 SHOW LOGIN PAGE (GET)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    // 🔹 HANDLE LOGIN (POST)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        UserDAO dao = new UserDAO();
        User user = dao.login(
                req.getParameter("email"),
                req.getParameter("password")
        );

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getId());
            session.setAttribute("userName", user.getName());

            resp.sendRedirect(req.getContextPath() + "/dashboard");

        } else {
            resp.sendRedirect(req.getContextPath() + "/login?error=invalid");
        }
    }
}
