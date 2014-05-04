<%-- 
    Document   : controlPanel
    Created on : 2013-12-26, 22:30:41
    Author     : Maciej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="Stylesheet" type="text/css" href="<c:url value="/resources/main.css" />" />
        <title>JSP Page</title>
    </head>
    <body>
        <div><a href="logOut">Wyloguj ${login}</a></div>
        <h1>${welcomeMessage}</h1>
        <div id ="centerAdmContent">
            <div id ="admContent">
                <div id="admMenu">
                    <a href="controlpanel">Strona Główna</a>
                    <a href="dodajNews">Newsy</a>
                    <a href="controlPanel.htm>?newsy">Galerie</a>
                </div>
                <div id="admContentText">
                    ${result}
                </div>
            </div>
        <div>
    </body>
</html>
