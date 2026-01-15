<%
    Integer uid = (Integer) session.getAttribute("userId");
    if (uid == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/app.css">

    <title>Add Task</title>


</head>

<body>

<div class="form-container">

    <h2>Add New Task</h2>

    <!-- ✅ Correct servlet mapping -->
    <form action="<%=request.getContextPath()%>/addTask" method="post">

        <input type="text" name="title" placeholder="Task Title" required />

        <textarea name="description" placeholder="Task Description" required></textarea>

        <button type="submit">Add Task</button>
    </form>

    <a class="back" href="<%=request.getContextPath()%>/dashboard.jsp">⬅ Back to Dashboard</a>
</div>

</body>
</html>
