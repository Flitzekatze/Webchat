<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Of Users</title>
	</head>
	<body>
		<h1>Users</h1>	
		<a href="../GenerateTestdata.htm">generateTestData</a>	<br>
		<a href="../Chatroom/ListChatroom.htm">Chatrooms</a>		
		<a href="../Account/ListAccount.htm">Accounts</a>
		<table border="1">
			<tr>
				<td>ID</td><td>Vorname</td><td>Nachname</td><td>Date of Birth</td><td>Gender</td><td>Picture</td><td>Favourite Chatrooms</td><td></td>
			</tr>
			<c:forEach items="${listOfUsers}" var="user">
				<tr>
					<td><c:out value="${user.getId() }"></c:out></td>
					<td><c:out value="${user.getFirstname() }"></c:out></td>
                    <td><c:out value="${user.getLastname() }"></c:out></td>
					<td><c:out value="${user.getDateOfBirth() }"></c:out></td>
					<td><c:out value="${user.getGender() }"></c:out></td>
					<td><c:out value="${user.getUserPicture() }"></c:out></td>
					<td>
						<c:forEach items="${user.getFavouriteChatrooms()}" var="chatroom">
							<a href="../Chatroom/EditChatroom.htm?id=${chatroom.getId() }"><c:out value="${chatroom.getChatroomName() }"></c:out></a>
						</c:forEach>
					</td>
					<td><a href="EditUser.htm?id=${user.getId() }">edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>