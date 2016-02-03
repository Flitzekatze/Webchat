<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Of Chatrooms</title>
	</head>
	<body>
		<h1>Chatrooms</h1>
		<a href="../GenerateTestdata.htm">GenerateTestdata</a><br>
		<a href="../User/ListUser.htm">User</a>
        <a href="../Account/ListAccount.htm">Accounts</a>        
		<a href="NewChatroom.htm">create new chatroom</a>
		<table border="1">
			<tr>
				<td>ID</td><td>Name</td><td>maxUser</td><td>User</td><td></td>
			</tr>
			<c:forEach items="${listOfChatrooms}" var="chatroom">
				<tr>
					<td><c:out value="${chatroom.getId() }"></c:out></td>
					<td><c:out value="${chatroom.getChatroomName() }"></c:out></td>
					<td><c:out value="${chatroom.getMaxUser() }"></c:out></td>
					<td>
						<c:forEach items="${chatroom.getActiveUsers()}" var="user">
							<a href="../User/Edit.htm?id=${user.getId() }"><c:out value="${user.getFirstname() }"></c:out></a><br>
						</c:forEach>
					</td>
					<td><a href="Edit.htm?id=${chatroom.getId() }">edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>