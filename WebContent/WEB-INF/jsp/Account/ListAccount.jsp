<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>List Of Accounts</title>
    </head>
    <body>
        <h1>Accounts</h1>
        <a href="../GenerateTestdata.htm">GenerateTestdata</a><br>
        <a href="../Chatroom/ListChatroom.htm">Chatrooms</a>        
        <a href="../User/ListUser.htm">User</a>
        <a href="NewAccount.htm">create new Account</a>
        <table border="1">
            <tr>
                <td>ID</td><td>Username</td><td>Password</td><td>E-Mail</td><td>User</td><td>Active</td><td></td>
            </tr>
            <c:forEach items="${listOfAccounts}" var="account">
                <tr>
                    <td><c:out value="${account.getId() }"></c:out></td>
                    <td><c:out value="${account.getUsername() }"></c:out></td>
                    <td><c:out value="${account.getPassword() }"></c:out></td>
                    <td><c:out value="${account.getE_mail() }"></c:out></td>
                    <td>
                        <a href="../User/EditUser.htm?id=${account.getUser().getId() }"><c:out value="${account.getUser().getFirstname() }"></c:out></a><br>
                    </td>
                    <td><c:out value="${account.getActive() }"></c:out></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>