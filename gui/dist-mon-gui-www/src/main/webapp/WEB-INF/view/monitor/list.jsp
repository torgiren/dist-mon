<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>List of monitors</h2>

    <ul>
        <c:forEach var="monitor" items="${monitors}">
            <li> <a href="<c:url value="/monitor/${monitor.id}" />">Monitor ${monitor.id} (${monitor.name})</a> </li>
        </c:forEach>
    </ul>
</t:layout>