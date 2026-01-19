<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyDiary</title>

<!-- CSS -->
<link rel="stylesheet" href="<c:url value="/css/style.css"/>">

</head>
<body>

<!-- HEADER -->
<div class="header">
    <img class="image" src="<c:url value="/images/diary.jpg"/>" alt="logo">
    <h3>MyDiary App</h3>
</div>

<!-- MAIN CONTENT -->
<div class="container">

    <!-- LEFT SECTION -->
    <div class="sec1">
        <img class="side" src="<c:url value="/images/diary.jpg"/>" alt="diary">
    </div>

    <!-- RIGHT SECTION -->
    <div class="sec2">
        <h4>Login Here</h4>

        <form action="./homepage" method="POST">
            <label>UserName</label><br>
            <input type="text" name="username"><br>

            <label>Password</label><br>
            <input type="password" name="password"><br>

            <button type="submit">Login</button>
        </form>
    </div>

</div>

<!-- FOOTER -->
<div class="footer">
    <p>
        New user?
       <a href="./register">Register now</a> 
    </p>
</div>


</body>
</html>
