<%@ page isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>">
<meta charset="UTF-8">
<title>Error Page</title>
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
        <p>${error}</p>
    </div>

</div>

<!-- FOOTER -->
<div class="footer">
    <p>
        New user?
       <a href="./register">Register now</a> 
      </p>
      <p>
       Existing user
       <a href="./login">Login now</a>
    </p>
</div>


</body>
</html>

</body>
</html>