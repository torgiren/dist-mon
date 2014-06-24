<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>Host ${host.id} - details</h2>
    <table class="details_table">
        <tbody>
            <tr>
                <td>Name:</td>
                <td>${host.name}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${host.address}</td>
            </tr>
            <tr>
                <td>Monitor:</td>
                <td>
                    <c:if test="${host.monitor != null}"> <a href="<c:url value="/monitor/${host.monitor}" />">Monitor ${host.monitor}</a> </c:if>
                    <c:if test="${host.monitor == null}"> <i>None</i> </c:if>
                </td>
            </tr>
            <tr>
                <td>Active:</td>
                <td>${host.active}</td>
            </tr>
            <tr>
                <td>Downtime:</td>
                <td>${host.downtime}</td>
            </tr>
            <tr>
                <td>Services:</td>
                <td>
                    <ul>
                        <c:forEach var="service" items="${host.services}">
                            <li> <a href="<c:url value="/service/${service}" />">Service ${service}</a> </li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </tbody>
    </table>
</t:layout>