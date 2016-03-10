<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Of Chatrooms</title>
	</head>
	<body>
		<h1>User</h1>
		<a href="List.htm">Chatrooms</a>		
		<a href="../User/List.htm">User</a>
		<table border="1">
			<tr>
				<td>ID</td><td>Name</td><td>Date of Birth</td><td>Gender</td><td>Picture</td><td>Favourite Chatrooms</td><td></td>
			</tr>
			<tr>
				<td><c:out value="${user.getId() }"></c:out></td>
				<td><c:out value="${user.getUsername() }"></c:out></td>
				<td><c:out value="${user.getDateOfBirth() }"></c:out></td>
				<td><c:out value="${user.getGender() }"></c:out></td>
				<td><c:out value="${user.getUserPicture() }"></c:out></td>
				<td>
					<c:forEach items="${user.getFavouriteChatrooms()}" var="chatroom">
						<a href="../Chatroom/Edit.htm?id=${chatroom.getId() }"><c:out value="${chatroom.getChatroomName() }"></c:out></a>
					</c:forEach>
				</td>
				<td><a href="Edit.htm?id=${user.getId() }">edit</a></td>
			</tr>
		</table>
		<h1>Chatrooms</h1>
		<a href="NewChatroom.htm">create new chatroom</a>
		<table border="1">
			<tr>
				<td>ID</td><td>Name</td><td>maxUser</td><td>User</td><td>Join Chatroom</td><td>make favourite</td>
			</tr>
			<c:forEach items="${listOfChatrooms}" var="chatroom">
				<tr>
					<td><c:out value="${chatroom.getId() }"></c:out></td>
					<td><c:out value="${chatroom.getChatroomName() }"></c:out></td>
					<td><c:out value="${chatroom.getMaxUser() }"></c:out></td>
					<td>
						<c:forEach items="${chatroom.getActiveUsers()}" var="user">
							<a href="../User/Edit.htm?id=${user.getId() }"><c:out value="${user.getusernaaame() }"></c:out></a>
						</c:forEach>
					</td>
					<td>
						<form:form action="addUserToChatroom.htm" method="post">
							<input type="hidden" name="chatroomID" value="${chatroom.getId() }">							
							<input type="hidden" name="userID" value="${user.getId() }">
							<input type="submit" value="Join"/>
						</form:form>
					
					<td>
						<form:form action="addChatroomToFavourite.htm" method="post">
							<input type="hidden" name="chatroomID" value="${chatroom.getId() }">							
							<input type="hidden" name="userID" value="${user.getId() }">
							<input type="submit" value="Favourite"/>
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>