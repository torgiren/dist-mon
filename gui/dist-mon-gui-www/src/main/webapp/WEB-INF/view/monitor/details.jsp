<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>Monitor ${monitor.id} - details</h2>
    <table class="details_table">
        <tbody>
            <tr>
                <td>Name:</td>
                <td>${monitor.name}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${monitor.address}</td>
            </tr>
            <tr>
                <td>Sync:</td>
                <td>${monitor.sync}</td>
            </tr>
            <tr>
                <td>Downtime:</td>
                <td>${monitor.downtime}</td>
            </tr>
            <tr>
                <td>Hosts:</td>
                <td>
                    <ul>
                        <c:forEach var="host" items="${monitor.hosts}">
                            <li> <a href="<c:url value="/host/${host}" />">Host ${host}</a> </li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </tbody>
    </table>
</t:layout>