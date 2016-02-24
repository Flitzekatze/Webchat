<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hallo</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of User</h2>  
    <table>
        <tr>
            <td>Firstname</td><td>Lastname</td><td>Gender</td><td>Date of birth</td><td>Date of birth</td><td></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td><a href="<c:url value='/edit-${user.ssn}-account' />">${account.ssn}</a></td>
            <td><a href="<c:url value='/delete-${account.ssn}-account' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Account</a>
</body>
</html>