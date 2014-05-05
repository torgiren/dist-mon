<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>Service ${service.id} - details</h2>
    <table class="details_table">
        <tbody>
            <tr>
                <td>Name:</td>
                <td>${service.name}</td>
            </tr>
            <tr>
                <td>Command:</td>
                <td>${service.command}</td>
            </tr>
            <tr>
                <td>Arguments:</td>
                <td>
                    <ul>
                        <c:forEach var="arg" items="${service.args}">
                            <li>${arg}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>Frequency:</td>
                <td>${service.freq}</td>
            </tr>
            <tr>
                <td>Hard:</td>
                <td>${service.hard}</td>
            </tr>
            <tr>
                <td>Downtime:</td>
                <td>${service.downtime}</td>
            </tr>
            <tr>
                <td>Hosts:</td>
                <td>
                    <ul>
                        <c:forEach var="host" items="${service.hosts}">
                            <li> <a href="<c:url value="/host/${host}" />">Host ${host}</a> </li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </tbody>
    </table>
</t:layout>