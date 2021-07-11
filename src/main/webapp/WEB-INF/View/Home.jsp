<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<form action="HomeController" method="post">
		<h1>Information Personal</h1>
		<label>Student's Name: </label>
		<input type="text" name="student"/> <br> <br>
		<label>Province: </label>
		<select name="provincelist">
			<c:forEach items="${listprovince}" var="l">
				<option value="${l.idProvince}">${l.name}</option>
			</c:forEach>

		</select> <br> <br>
		<input type="submit" value="Register">
	</form>
	<h3> <%=request.getAttribute("messinsert") !=null ? request.getAttribute("messinsert") : " "  %> </h3>
</body>
</html>