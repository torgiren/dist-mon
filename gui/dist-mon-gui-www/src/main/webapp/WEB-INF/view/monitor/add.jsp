<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>Add monitor</h2>

    <form:form class="form-horizontal" method="POST" modelAttribute="monitor">
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
                    <td><form:label path="hosts">Hosts:</form:label></td>
                    <td><form:select multiple="true" path="hosts" items="${availableHosts}" itemLabel="name" itemValue="id" /></td>
                </tr>
                <tr>
                    <td><form:label path="sync">Sync:</form:label></td>
                    <td><form:input type="text" path="sync" /></td>
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