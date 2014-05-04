<%-- 
    Document   : adm
    Created on : 2014-01-18, 19:46:30
    Author     : Maciej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <h1>${result}</h1>
        <div id ="centerAdmContent">
            <div id ="admContent">
                <div id="admMenu">
                    <a href="/pr1/controlpanel">Strona Główna</a>
                    <a href="/pr1/dodajNews">Galerie</a>
                    <a href="controlPanel.htm>?newsy">Newsy</a>
                </div>
                <div id="admContentText">
                    <div id="formNews">
                    <form:form method="post"  modelAttribute="news">
                        <form:hidden path="id" />
                                
                    Tytuł<br />
                    <form:input id="newsTitle" type="text" path="title" />
                    <br />Kategoria:<br />
                    
                    <form:input type="text"  path="kategoria" />
                    <br />Treść:<br />
                    <form:textarea id="newsContent"  
                                   path="content" ></form:textarea>
                    <br />
                    <input type="submit" value="zapisz" />
                    </div>
                    <div id="formNewsView">
                        ${Newsy}
                    </div>
            </form:form>
                </div>
            </div>
        <div>
    </body>
</html>