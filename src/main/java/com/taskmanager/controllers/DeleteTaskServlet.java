package com.taskmanager.controllers;

import java.io.IOException;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.dao.TaskHistoryDAO;
import com.taskmanager.model.Task;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("userId") == null) {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }

            int userId = (int) session.getAttribute("userId");
            int taskId = Integer.parseInt(req.getParameter("id"));

            TaskDAO taskDAO = new TaskDAO();

            // 🔹 FETCH TASK BEFORE DELETE (for history)
            Task task = taskDAO.getTaskById(taskId, userId);
            if (task == null) {
                resp.sendRedirect(req.getContextPath() + "/dashboard");
                return;
            }

            String title = task.getTitle();

            // 🔹 DELETE TASK
            taskDAO.deleteTask(taskId, userId);

            // 🔹 LOG HISTORY (DELETED)
            TaskHistoryDAO.log(taskId, userId, "DELETED", title);

            // 🔹 Redirect back
            resp.sendRedirect(req.getContextPath() + "/dashboard");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/dashboard?error=delete_failed");
        }
    }
}
