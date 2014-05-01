<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h1>List of hosts!</h1>

    <ul>
        <c:forEach var="host" items="${hosts}">
            <li> <a href="<c:url value="${host.url}" />"> ${host.name} </a> </li>
        </c:forEach>
    </ul>
</t:layout>