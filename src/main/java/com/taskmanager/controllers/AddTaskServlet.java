package com.taskmanager.controllers;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.dao.TaskHistoryDAO;
import com.taskmanager.model.Task;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("userId") == null) {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
                return;
            }

            int userId = (int) session.getAttribute("userId");

            String title = req.getParameter("title");
            String description = req.getParameter("description");

            Task task = new Task(
                    title,
                    description,
                    "Pending",
                    userId
            );

            // ADD TASK
            int taskId = new TaskDAO().addTask(task); 
            //  addTask() must return generated task ID

            //  LOG HISTORY (CREATED)
            TaskHistoryDAO.log(taskId, userId, "CREATED", title);

            //  Redirect to dashboard
            resp.sendRedirect(req.getContextPath() + "/dashboard");

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error adding task");
        }
    }
}
