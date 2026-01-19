<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyDiary - Home</title>

<link rel="stylesheet" href="<c:url value='/css/style.css'/>">

</head>
<body>
<div class="homeheader">

<h2>Welcome ${username}</h2>
<a href="./signout" class="add">signout</a>
</div>
<div class="past">

<h3>List of past entries</h3>
<a href="./addentry" class="add">Add Entry</a>
</div>

<table class="diary-table">

    <!-- TABLE HEADER -->
    <thead>
        <tr>
            <th>Date</th>
            <th colspan="3">Actions</th>
        </tr>
    </thead>

    <!-- TABLE BODY -->
    <tbody>
	<c:forEach var="e" items="${entriesList}">
            <tr>

                <!-- Date format yyyy-MM-dd -->
                <td>
               <fmt:formatDate value="${e.entryDate }" pattern="yyyy-MM-dd"/>
                </td>

                <td>
                    <a href="./view?id=${e.id }">View</a>
                </td>
                <td>
                    <a href="./update?id=${e.id }">Update</a>
                </td>
                <td>
                    <a href="./delete?id=${e.id }">
                       Delete
                    </a>
                </td>

            </tr>
            </c:forEach>

    </tbody>

</table>

</body>
</html>
