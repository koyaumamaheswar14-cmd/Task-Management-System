package com.taskmanager.controllers;

import com.taskmanager.dao.TaskDAO;
import com.taskmanager.model.Task;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        Integer userId = (Integer) req.getSession().getAttribute("userId");

        if (userId == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        List<Task> tasks = null;
		try {
			tasks = new TaskDAO().getTasksByUser(userId);
		} catch (Exception e) {
	
			e.printStackTrace();
		}

        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
