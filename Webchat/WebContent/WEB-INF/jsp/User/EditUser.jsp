<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit User</title>
	</head>
	<body>
		<form:form action="saveOrUpdateUser.htm" commandName="user">

            Vorname: <form:input path="firstname"/><br/>
			Nachname: <form:input path="lastname"/><br/>
			Date of birth: <form:input path="dateOfBirth"/><br/>
			Gender: <form:input path="gender"/><br/>			
			Picture: <form:input path="userPicture"/><br/>
			
	
			<form:hidden path="id"/>
			<form:hidden path="favouriteChatrooms"/>
	
			<input type="submit" value="save"/>
		</form:form>
	</body>
</html>