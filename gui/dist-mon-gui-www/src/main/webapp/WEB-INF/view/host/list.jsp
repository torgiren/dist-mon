<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/styles/main.css" />" rel="stylesheet" />
        
        <title>Spring MVC Starter</title>
    </head>
    <body>
        <h1>List of hosts!</h1>
        
        <c:forEach var="host" items="${hosts}">
            <p> 
                ${host.name} : ${host.url}
            </p>
        </c:forEach>
    </body>
</html>
