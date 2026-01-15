package com.taskmanager.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.taskmanager.dao.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");

        // Validate passwords
        if (!password.equals(confirm)) {
            request.setAttribute("error", "Passwords do not match");
            request.setAttribute("email", email);
            request.getRequestDispatcher("resetPassword.jsp")
                   .forward(request, response);
            return;
        }

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement("UPDATE users SET password = ? WHERE email = ?");
            ps.setString(1, password);   // ⚠ plain text (hash later)
            ps.setString(2, email);

            ps.executeUpdate();

            // Redirect to login
            response.sendRedirect("login.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Failed to update password");
            request.setAttribute("email", email);
            request.getRequestDispatcher("resetPassword.jsp")
                   .forward(request, response);
        }
    }
}
