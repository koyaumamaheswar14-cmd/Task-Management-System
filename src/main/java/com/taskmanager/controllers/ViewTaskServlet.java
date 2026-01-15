package com.taskmanager.controllers;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.model.Task;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewTasks")
public class ViewTaskServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int userId = (int) req.getSession().getAttribute("userId");

            List<Task> tasks = new TaskDAO().getTasksByUser(userId);
            req.setAttribute("tasks", tasks);
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
