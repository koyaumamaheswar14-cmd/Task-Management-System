<%@ page language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/app.css">

<meta charset="UTF-8">
<title>Register</title>


</head>

<body>

<div class="form-container">

    <h2>REGISTER</h2>

    <form method="post" action="<%=request.getContextPath()%>/register">

        <label>Name</label>
        <input type="text" name="name" placeholder="Enter name" required>

        <label>Email</label>
        <input type="email" name="email" placeholder="Enter email" required>

        <label>Password</label>
        <input type="password" name="password" placeholder="Create password" required>

        <button type="submit">Create Account</button>
    </form>

    <div class="links">
        <a href="<%=request.getContextPath()%>/login.jsp">Back to Login</a>
    </div>

</div>

</body>
</html>
