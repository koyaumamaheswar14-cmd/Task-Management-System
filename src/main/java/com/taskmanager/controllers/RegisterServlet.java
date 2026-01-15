package com.taskmanager.controllers;

import com.taskmanager.dao.UserDAO;
import com.taskmanager.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User(
                req.getParameter("name"),
                req.getParameter("email"),
                req.getParameter("password")
        );

        UserDAO dao = new UserDAO();

        if (dao.register(user)) {
            resp.sendRedirect("login.jsp");
        } else {
            resp.getWriter().println("Registration Failed");
        }
    }
}
