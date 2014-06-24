<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>Add host</h2>

    <form:form class="form-horizontal" method="POST" modelAttribute="host">
        <table class="details_table">
            <tbody>
                <tr>
                    <td><form:label path="name">Name:</form:label></td>
                    <td><form:input type="text" path="name" /></td>
                </tr>
                <tr>
                    <td><form:label path="address">Address:</form:label></td>
                    <td><form:input type="text" path="address" /></td>
                </tr>
                <tr>
                    <td><form:label path="monitor">Monitor:</form:label></td>
                    <td><form:select multiple="false" path="monitor" items="${availableMonitors}" itemLabel="name" itemValue="id" /></td>
                </tr>
                <tr>
                    <td><form:label path="active">Active:</form:label></td>
                    <td><form:input type="text" path="active" /></td>
                </tr>
                <tr>
                    <td><form:label path="downtime">Downtime:</form:label></td>
                    <td><form:input type="text" path="downtime" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Add" /></td>
                </tr>
            </tbody>
        </table>
    </form:form>
</t:layout>