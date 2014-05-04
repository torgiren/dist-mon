<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<t:layout>
    <h2>Host details!</h2>

    <p> ${host.name} </p>
    <p> ${host.address} </p>
    <p> ${host.id} </p>
    <p> ${host.downtime} </p>
    <p> ${host.active} </p>
    <p> ${host.url} </p>
    
    <h2> Monitors inside host </h2>
    
    
    
</t:layout>