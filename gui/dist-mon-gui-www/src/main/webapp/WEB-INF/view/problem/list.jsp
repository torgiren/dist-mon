<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>List of problems!</h2>

    <ul>
        <c:forEach var="problem" items="${problems}">
            <li> <a href="<c:url value="/problem/${problem.id}" />"> ${problem.status} </a> </li>
        </c:forEach>
    </ul>
</t:layout>