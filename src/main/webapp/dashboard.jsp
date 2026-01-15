<%@ page import="java.util.*,com.taskmanager.model.Task" %>
<%
    Integer uid = (Integer) session.getAttribute("userId");
    if (uid == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }

    String userName = (String) session.getAttribute("userName");
    if (userName == null) {
        userName = "User";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Task Management System</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #e0f2fe, #f8fafc);
            min-height: 100vh;
        }

        .layout {
            display: flex;
            min-height: 100vh;
        }

        .sidebar {
            width: 240px;
            background: white;
            padding: 25px 15px;
            box-shadow: 4px 0 15px rgba(0,0,0,0.1);
            display: flex;
            flex-direction: column;
        }

        /* 🔹 WELCOME */
        .welcome {
            text-align: center;
            margin-bottom: 20px;
            padding-bottom: 15px;
            border-bottom: 1px solid #e5e7eb;
        }

        .welcome p {
            margin: 0;
            font-size: 20px;      /* INCREASED SIZE */
            color: #1f2937;
            font-weight: bold;
        }

        .welcome h3 {
            margin: 6px 0 0;
            font-size: 18px;
            color: #2563eb;
            font-weight: bold;
        }

        .sidebar h4 {
            text-align: center;
            color: #2563eb;
            margin-bottom: 25px;
        }

        .nav-btn {
            padding: 12px;
            margin-bottom: 14px;
            border-radius: 10px;
            font-weight: bold;
            font-size: 15px;
            text-align: center;
            text-decoration: none;
            border: none;
            cursor: pointer;
            display: block;
        }

        .btn-add { background: #22c55e; color: white; }
        .btn-filter { background: #3b82f6; color: white; }
        .btn-edit { background: #f59e0b; color: white; }
        .btn-delete { background: #dc2626; color: white; }
        .btn-history { background: #6366f1; color: white; }

        .btn-logout {
            background: #7c2d12;
            color: white;
            margin-top: auto;
        }

        .content {
            flex: 1;
            padding: 30px;
            position: relative;
        }

        h2 {
            text-align: center;
            color: #2563eb;
            margin-bottom: 20px;
        }

        .filter-dropdown {
            display: none;
            position: absolute;
            left: 20px;
            top: 90px;
            background: white;
            border-radius: 12px;
            padding: 14px 20px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.25);
            z-index: 9999;
            width: 200px;
        }

        .table-card {
            background: rgba(255,255,255,0.4);
            backdrop-filter: blur(12px);
            border-radius: 16px;
            box-shadow: 0 12px 30px rgba(0,0,0,0.1);
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background: #2563eb;
            color: white;
            padding: 14px;
            text-align: center;
        }

        td {
            padding: 14px;
            text-align: center;
        }

        .status-pending { color: #d97706; font-weight: bold; }
        .status-completed { color: #16a34a; font-weight: bold; }
        .status-cancel { color: #dc2626; font-weight: bold; }
    </style>

    <script>
        function toggleFilter() {
            const box = document.getElementById("filterBox");
            box.style.display = box.style.display === "block" ? "none" : "block";
        }

        function getSelectedTask() {
            const radio = document.querySelector('input[name="taskId"]:checked');
            if (!radio) {
                alert("Please select a task first");
                return null;
            }
            return radio.value;
        }

        function editTask() {
            const id = getSelectedTask();
            if (id) {
                window.location.href = "<%=request.getContextPath()%>/editTask?id=" + id;
            }
        }

        function deleteTask() {
            const id = getSelectedTask();
            if (id && confirm("Are you sure you want to delete this task?")) {
                window.location.href = "<%=request.getContextPath()%>/deleteTask?id=" + id;
            }
        }
    </script>
</head>

<body>

<div class="layout">

    <div class="sidebar">
        <div class="welcome">
            <p>Welcome</p>
            <h3><%= userName %></h3>
        </div>

        <h4>Task Panel</h4>

        <a class="nav-btn btn-add" href="<%=request.getContextPath()%>/addTask.jsp">Add Task</a>
        <button class="nav-btn btn-filter" onclick="toggleFilter()">Filter</button>
        <button class="nav-btn btn-edit" onclick="editTask()">Edit Task</button>
        <button class="nav-btn btn-delete" onclick="deleteTask()">Delete Task</button>
        <a class="nav-btn btn-history" href="<%=request.getContextPath()%>/history">History</a>
        <a class="nav-btn btn-logout" href="<%=request.getContextPath()%>/logout">Logout</a>
    </div>

    <div class="content">
        <h2>My Tasks</h2>

        <div id="filterBox" class="filter-dropdown">
            <form method="get" action="<%=request.getContextPath()%>/tasks">
                <label><input type="checkbox" name="status" value="Pending"> Pending</label><br><br>
                <label><input type="checkbox" name="status" value="Completed"> Completed</label><br><br>
                <label><input type="checkbox" name="status" value="Cancel"> Cancel</label><br><br>
                <button type="submit">Apply</button>
            </form>
        </div>

        <div class="table-card">
            <table>
                <tr>
                    <th>Select</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Status</th>
                </tr>

<%
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
    if (tasks != null && !tasks.isEmpty()) {
        for (Task t : tasks) {
            String cls = "status-pending";
            if ("Completed".equals(t.getStatus())) cls = "status-completed";
            if ("Cancel".equals(t.getStatus())) cls = "status-cancel";
%>
                <tr>
                    <td><input type="radio" name="taskId" value="<%=t.getId()%>"></td>
                    <td><%=t.getTitle()%></td>
                    <td><%=t.getDescription()%></td>
                    <td class="<%=cls%>"><%=t.getStatus()%></td>
                </tr>
<%
        }
    } else {
%>
                <tr>
                    <td colspan="4">No tasks found</td>
                </tr>
<%
    }
%>
            </table>
        </div>
    </div>
</div>

</body>
</html>
