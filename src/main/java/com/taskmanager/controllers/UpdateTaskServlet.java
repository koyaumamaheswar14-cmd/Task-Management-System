package com.taskmanager.controllers;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.dao.TaskHistoryDAO;
import com.taskmanager.model.Task;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateTask")
public class UpdateTaskServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("userId") == null) {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }

            int userId = (int) session.getAttribute("userId");

            int taskId = Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String status = req.getParameter("status");

            Task task = new Task();
            task.setId(taskId);
            task.setTitle(title);
            task.setDescription(description);
            task.setStatus(status);
            task.setUserId(userId);

            // UPDATE TASK
            new TaskDAO().updateTask(task);

            //  LOG HISTORY (UPDATED)
            TaskHistoryDAO.log(taskId, userId, "UPDATED", title);

            //  Redirect back to dashboard
            resp.sendRedirect(req.getContextPath() + "/dashboard");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/dashboard?error=update_failed");
        }
    }
}
