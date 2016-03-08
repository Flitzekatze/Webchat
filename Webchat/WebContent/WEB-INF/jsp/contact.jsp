<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Styles/Contact.css">
</head>
<body>
    <form id="contactFormular" method="post" action="">
        <fieldset id="formularField">
            <label id="formularTop">Contact</label><br/><br/>
            <label id="letter">Ihre Daten</label><br/>
            
            <label>Anrede:</label>      <input type="radio" name="salutation" value="Herr" style="margin-right:5px;" />Herr<input type="radio" name="Anrede" value="Frau" style="margin:0 5px 0 20px;" />Frau<br/>
            <label>Name:</label>        <input type="text" name="name" value="" class="kFormular"><br/>
            <label>Vorname:</label>     <input type="text" name="firstName" value="" class="kFormular"><br/>
            <label>E-Mail:</label>      <input type="text" name="email" value="" class="kFormular"><br/><br/><br/>
            
            <label id="letter">Ihre Nachricht</label><br/>
            
            <label>Betreff:</label>     <input type="text" name="subject" value="" class="kFormular"><br/><br/>
            <label>Nachricht:</label>   <textarea name="message" cols="25" rows="5"></textarea><br/>
            <input id="sendForm" type="submit" value="Senden"/>
        </fieldset>
    </form>
</body>
</html>