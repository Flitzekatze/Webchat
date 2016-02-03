<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Edit Account</title>
    </head>
    <body>
        <form:form action="saveOrUpdateAccount.htm" commandName="account">

            Username: <form:input path="username"/><br/>
            Password: <form:input path="password"/><br/>
            E-Mail: <form:input path="e_mail"/><br/>            
            Active: <form:input path="active"/><br/>
            
            <form:hidden path="user"/>
            <form:hidden path="id"/>
    
            <input type="submit" value="save"/>
        </form:form>
    </body>
</html>