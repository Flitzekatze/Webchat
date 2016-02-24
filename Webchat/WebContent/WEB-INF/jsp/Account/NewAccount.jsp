<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>Create Account</h1>

<form:form action="saveOrUpdateAccount.htm" commandName="account">
Username:   <form:input path="username"/><br/>
Password:   <form:input path="password"/><br/>
E-Mail:     <form:input path="e_mail"/><br>     
Active:     <form:input path="active"/><br>
<input type="submit" value="save"/>




</form:form>