<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>List of services</h2>

    <ul>
        <c:forEach var="service" items="${services}">
            <li> <a href="<c:url value="/service/${service.id}" />">Service ${service.id}</a> </li>
        </c:forEach>
    </ul>
</t:layout>