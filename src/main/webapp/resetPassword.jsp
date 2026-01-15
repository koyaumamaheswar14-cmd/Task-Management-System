<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/app.css">

    <title>Reset Password</title>

  

</head>
<body>

<div class="form-container">

    <h2>Reset Password</h2>

    <form action="<%=request.getContextPath()%>/resetPassword" method="post">

        <input type="hidden" name="email" value="<%= request.getAttribute("email") %>">

        <label>New Password</label>
        <input type="password" name="password" placeholder="Enter new password" required>

        <label>Confirm Password</label>
        <input type="password" name="confirm" placeholder="Confirm new password" required>

        <button type="submit">Update Password</button>
    </form>

    <div class="error">
        <%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
    </div>

</div>

</body>
</html>
