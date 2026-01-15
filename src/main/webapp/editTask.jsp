<%@ page import="com.taskmanager.model.Task" %>
<%
    Task task = (Task) request.getAttribute("task");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/app.css">

    <title>Edit Task</title>

</head>
<style>
/* =====================
   EDIT TASK CONTAINER
===================== */
.container {
    width: 380px;
    max-width: 92%;
    margin: 60px auto;
    background: rgba(255, 255, 255, 0.7);
    backdrop-filter: blur(12px);
    padding: 30px;
    border-radius: 16px;
    box-shadow: 0 12px 30px rgba(0,0,0,0.18);
    border: 1px solid rgba(255,255,255,0.6);
}

/* =====================
   TITLE
===================== */
.container h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #0f172a;
}

/* =====================
   FORM ELEMENTS
===================== */
.container input,
.container select {
    width: 100%;
    padding: 10px;
    margin-bottom: 16px;
    border-radius: 8px;
    border: 1px solid #cbd5f5;
    font-size: 14px;
    background: #ffffff;
    color: #0f172a;
}

/* =====================
   SELECT DROPDOWN
===================== */
.container select {
    cursor: pointer;
}

/* =====================
   BUTTON
===================== */
.container button {
    width: 100%;
    padding: 10px;
    border-radius: 25px;
    border: none;
    background: #2563eb;
    color: white;
    font-size: 15px;
    font-weight: bold;
    cursor: pointer;
}

.container button:hover {
    background: #1e40af;
}

</style>
<body>

<div class="container">

    <h2>Edit Task</h2>

    <form action="<%=request.getContextPath()%>/updateTask" method="post">

        <input type="hidden" name="id" value="<%=task.getId()%>">

        <input type="text" name="title" value="<%=task.getTitle()%>" required>

        <input type="text" name="description" value="<%=task.getDescription()%>" required>

        <select name="status">
            <option <%=task.getStatus().equals("Pending") ? "selected" : ""%>>Pending</option>
            <option <%=task.getStatus().equals("Cancel") ? "selected" : ""%>>Cancel</option>
            <option <%=task.getStatus().equals("Completed") ? "selected" : ""%>>Completed</option>
        </select>

        <button type="submit">Update Task</button>

    </form>

</div>

</body>
</html>
