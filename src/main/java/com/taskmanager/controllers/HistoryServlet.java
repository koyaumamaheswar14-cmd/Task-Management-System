package com.taskmanager.controllers;

import com.taskmanager.dao.TaskHistoryDAO;
import com.taskmanager.model.TaskHistory;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        List<TaskHistory> history =
                TaskHistoryDAO.getByUser(userId);

        req.setAttribute("history", history);
        req.getRequestDispatcher("history.jsp")
           .forward(req, resp);
    }
}
