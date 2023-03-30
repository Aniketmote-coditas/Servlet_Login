<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<form method ="get" action="hello">
        <label>First Name</label>
        <input type="text" name ="first_name"><br/>
        <label>Last Name</label>
        <input type="text" name ="last_name"><br/>
        <label>Date Of Birth</label>
        <input type="text" name ="dob"><br/>
        <label>Email</label>
        <input type="text" name ="email"><br/>
        <label>Password</label>
        <input type="password" name ="password"><br/>
        <label>Image</label>
        <input type="file" name ="img"><br/>
        <label>Resume</label>
        <input type="file" name ="resume"><br/>
        <label>Address</label>
        <input type="text" name ="address"><br/>
        <label>Phone Number</label>
        <input type="text" name ="phone"><br/>
        <input type ="Submit" value ="Submit">
        <input type ="Reset" value ="Reset">
    </form>
	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>
</body>
</html>
