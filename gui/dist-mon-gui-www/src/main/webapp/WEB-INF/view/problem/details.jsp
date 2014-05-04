<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>Problem details!</h2>

    <p> <a href="<c:url value="/service/${problem.service.id}" />"> ${problem.service.name} </a> </p>
    <p> <a href="<c:url value="/host/${problem.host.id}" />"> ${problem.host.name} </a> </p>
    <p> ${problem.id} </p>
    <p> ${problem.status} </p>
    <p> ${problem.value} </p>
    <p> ${problem.start} </p>
    <p> ${problem.stop} </p>
    <p> ${problem.ack} </p>
</t:layout>