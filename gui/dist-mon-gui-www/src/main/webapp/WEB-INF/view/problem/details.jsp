<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>Problem ${problem.id} - details</h2>
    <table class="details_table">
        <tbody>
            <tr>
                <td>Service:</td>
                <td><a href="<c:url value="/service/${problem.service}" />">Service ${problem.service} </a></td>
            </tr>
            <tr>
                <td>Host:</td>
                <td><a href="<c:url value="/host/${problem.host}" />">Host ${problem.host} </a></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td>${problem.status}</td>
            </tr>
            <tr>
                <td>Value:</td>
                <td>${problem.value}</td>
            </tr>
            <tr>
                <td>Start:</td>
                <td>${problem.start}</td>
            </tr>
            <tr>
                <td>Stop:</td>
                <td>${problem.stop}</td>
            </tr>
            <tr>
                <td>Ack:</td>
                <td>${problem.ack}</td>
            </tr>
        </tbody>
    </table>
</t:layout>