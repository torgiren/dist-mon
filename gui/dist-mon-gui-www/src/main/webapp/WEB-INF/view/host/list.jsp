<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h1>List of hosts!</h1>

    <c:forEach var="host" items="${hosts}">
        <p> 
            ${host.name} : ${host.url}
        </p>
    </c:forEach>
</t:layout>