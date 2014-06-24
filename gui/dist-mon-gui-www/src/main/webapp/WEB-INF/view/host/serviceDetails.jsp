<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>Service ${service.url} - details</h2>
    <table class="details_table">
        <tbody>
            <tr>
                <td>Name:</td>
                <td>${service.name}</td>
            </tr>
            <tr>
                <td>Value:</td>
                <td>${service.value}</td>
            </tr>
            <tr>
                <td>Graph:</td>
                <td>
                    <img src="${service.graph}" />
                </td>
            </tr>
        </tbody>
    </table>
</t:layout>