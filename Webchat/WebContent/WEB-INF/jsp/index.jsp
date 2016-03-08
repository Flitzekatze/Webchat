<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<html>
<head>
<script>
var cp = "<%=request.getContextPath()%>";
console.log(cp);
</script>

<title>Bonobo-Talk</title>
<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
<link rel="stylesheet" href="${cp}/static/Styles/Navigation.css">
<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${cp}/static/Scripts/functions.js"></script>
</head>
<body>
	<div id="mainContainer">
        <div id="navContainer">
        	<div id="logo"><img src="${cp}/static/Pictures/Logo.png" height="100%" alt="LOGO"/></div>
            <div id="accNlogin">
                <div id="loginButton"><a class="navItem" href="" id="loginLink">LOGIN</a></div>
            </div>
            <div id="navigation"></div>
        </div>
        <div id="contentContainer">
        	<div id="content">

            </div>
    	</div>
        <div id="footer">
        </div>
    </div>
    <div id="popupContainer">
    </div>
</body>
</html>
