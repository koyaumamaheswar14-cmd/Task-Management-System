package com.taskmanager.controllers;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.model.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/tasks")   //  THIS CREATES /tasks URL
public class TaskListServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer uid = (Integer) request.getSession().getAttribute("userId");
        if (uid == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String status = request.getParameter("status");

        TaskDAO dao = new TaskDAO();
        List<Task> tasks;

        try {
            if (status == null || status.isEmpty()) {
                // No filter → all tasks
                tasks = dao.getTasksByUser(uid);
            } else {
                // Filter applied
                tasks = dao.getTasksByStatus(uid, status);
            }

            request.setAttribute("tasks", tasks);
            request.getRequestDispatcher("dashboard.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
