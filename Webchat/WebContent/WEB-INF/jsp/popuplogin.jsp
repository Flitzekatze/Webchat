<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${cp}/static/Styles/Popuplogin.css">
</head>
<body>
    <div id="popupLogin">
        <div id="loginInfo"></div>
        <div id="loginFormContainer">
            <div id="toggleButtons">
                <div id="loginToggle" ><span>Login</span></div>
                <div id="signupToggle" class="inactiveBtn"><span>Signup</span></div>
            </div>
            <div id="login">
            <c:url var="loginUrl" value="/login" />
            <form action="${loginUrl}" method="post" class="form-horizontal">
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
                            <div>
                                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                <input type="text" class="textInput1" id="username" name="username" placeholder="Enter Username" required>
                            </div>
                            <div>
                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                                <input type="password" class="textInput1" id="password" name="password" placeholder="Enter Password" required>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />                
                            <div class="form-actions">
                                <input type="submit" class="subLogSign" value="Log in">
                                    </div>
                                    </form>
            </div>
            <div id="signup" style="display:none;">
            <form:form method="POST" modelAttribute="Account">
            <form:input type="hidden" path="id" id="id"/>
                <p><form:input class="textInput1" path="username" id="username"/></p>
                <p><form:errors path="username" cssClass="error"/></p>
                <p><form:input class="textInput1" path="password" id="password"/></p>
                <p><form:errors path="password" cssClass="error"/></p>
                <p><form:input class="textInput1" path="email" id="email"/></p>
                <p><form:errors path="email" cssClass="error"/></p>
                <p><form:input class="textInput1" path="ssn" id="ssn"/></p>
                <p><form:errors path="ssn" cssClass="error"/></p>
                <p><input type="submit" value="Register"/></p>
            </form:form>
            </div>
        </div>
    </div>
</body>
</html>
                        