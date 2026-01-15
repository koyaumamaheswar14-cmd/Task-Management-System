<%@ page language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/app.css">

<meta charset="UTF-8">
<title>Login</title>



</head>

<body>

<div class="form-container">

    <h2>LOGIN</h2>

    <% if ("invalid".equals(request.getParameter("error"))) { %>
        <div class="error">Invalid email or password</div>
    <% } %>

    <form method="post" action="<%=request.getContextPath()%>/login">

        <label>Email</label>
        <input type="email" name="email" placeholder="Enter email" required>

        <label>Password</label>
        <input type="password" name="password" placeholder="Enter password" required>

        <button type="submit">Login</button>
    </form>

    <div class="links">
        <a href="<%=request.getContextPath()%>/forgotPassword.jsp">Forgot Password?</a>
        <a href="<%=request.getContextPath()%>/register.jsp">Create Account</a>
    </div>

</div>

</body>
</html>
