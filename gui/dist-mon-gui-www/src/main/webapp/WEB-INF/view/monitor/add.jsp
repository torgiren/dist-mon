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
                    <td>Name:</td>
                    <td> <input path="name" /> </td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input path="address" /></td>
                </tr>
                <tr>
                    <td>Sync:</td>
                    <td><input path="sync" /></td>
                </tr>
                <tr>
                    <td>Downtime:</td>
                    <td><input path="downtime" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Add" /></td>
                </tr>
            </tbody>
        </table>
    </form:form>
</t:layout>