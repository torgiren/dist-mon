<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="<c:url value="/resources/main.css" />" />
    </head>
    <body>
        <form action="/zes/problem" method="POST">
            <input type="text" value="2" name="id" value="2"/>
            <input type="text" value="32" name="serviceId"/>
            <input type="text" value="32" name="hostId"/>
            <input type="text" value="status" name="status"/>
            <input type="text" value="32" name="value"/>
            <input type="text" value="start" name="start"/>
            <input type="text" value="start" name="stop"/>
            <input type="text" value="2" name="ack" />
            <button>addProblem</button>
        </form>
        
       <form action="/zes/service" method="POST">
           <input type="text" value="name" name="name"/>
            <input type="text" value="command" name="command"/>
            <input type="text" value="args" name="args"/>
            <input type="text" value="2" name="freq"/>
            <input type="text" value="1" name="hard"/>
            <input type="text" value="type" name="type"/>
            <button>AddService</button>
       </form>
        
        <form action="/zes/problem/1" method="POST">
            <input type="text" value="2" name="id" value="2"/>
            <input type="text" value="32" name="serviceId"/>
            <input type="text" value="32" name="hostId"/>
            <input type="text" value="status" name="status"/>
            <input type="text" value="32" name="value"/>
            <input type="text" value="start" name="start"/>
            <input type="text" value="start" name="stop"/>
            <input type="text" value="2" name="ack" />
            <button>addProblem</button>
        </form>
        
       <form action="/zes/service/2" method="POST">
           <input type="text" value="id" name="id"
           <input type="text" value="name" name="name"/>
            <input type="text" value="command" name="command"/>
            <input type="text" value="args" name="args"/>
            <input type="text" value="2" name="freq"/>
            <input type="text" value="1" name="hard"/>
            <input type="text" value="type" name="type"/>
            <button>AddService</button>
    </body>
</html>
