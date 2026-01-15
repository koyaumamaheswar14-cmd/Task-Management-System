<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/app.css">

    <title>Forgot Password</title>



</head>
<body>

<div class="form-container">

    <h2>Forgot Password</h2>

    <form action="<%=request.getContextPath()%>/forgotPassword" method="post">

        <label>Email</label>
        <input type="email" name="email" placeholder="Enter registered email" required>

        <button type="submit">Verify Email</button>
    </form>

    <div class="error">
        <%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
    </div>

    <div class="links">
        <a href="<%=request.getContextPath()%>/login.jsp">Back to Login</a>
    </div>

</div>

</body>
</html>
