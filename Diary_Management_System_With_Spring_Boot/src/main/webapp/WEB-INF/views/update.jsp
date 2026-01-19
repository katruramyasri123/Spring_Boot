<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

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
    <a href="./signout" class="add">signout</a>

    <!-- RIGHT SECTION -->
    <div class="sec2">
        <h4>VIEW HERE</h4>

        <form action="./save" method="POST">
            <label>Date</label><br>
            <input type="date" value="<fmt:formatDate value="${entry.entryDate }" pattern="yyyy-MM-dd"/>" name="entryDate" readonly>
            
            <label>Description</label><br>
            <textarea rows="10" cols="10" name="description" >
            ${entry.description}
            </textarea>
            <br>
            <input type="hidden" name="userid" value="${entry.userid }">
            <input type="hidden" name="id" value="${entry.id }">
            
            <br>
           <button type="submit">Update</button>
            
        </form>
    </div>
    <div>
     <a href="./home" class="add">Back</a>
     </div>
     

</div>




</body>
</html>
