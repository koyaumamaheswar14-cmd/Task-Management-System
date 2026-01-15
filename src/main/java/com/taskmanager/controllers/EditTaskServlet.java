package com.taskmanager.controllers;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.model.Task;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/editTask")
public class EditTaskServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int taskId = Integer.parseInt(req.getParameter("id"));
            int userId = (int) req.getSession().getAttribute("userId");

            Task task = new TaskDAO().getTaskById(taskId, userId);

            req.setAttribute("task", task);
            req.getRequestDispatcher("/editTask.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
