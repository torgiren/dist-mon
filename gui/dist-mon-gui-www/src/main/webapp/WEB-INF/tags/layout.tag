<%@tag description="MVC Template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/styles/style.css" />" rel="stylesheet" />

        <title>dist-mon www</title>
    </head>
    <body>
        <div class="header">
            <a href="<c:url value="/home" />">Disitributed monitoring GUI</a>
        </div>
        <div class="content">
            <div class="left-menu">
                <div class="left-menu-item">
                    <a href="<c:url value="/host/list" />">Hosts</a>
                </div>
                <div class="left-menu-item">
                    <a href="<c:url value="/service/list" />">Services</a>
                </div>
                <div class="left-menu-item">
                    <a href="<c:url value="/problem/list" />">Problems</a>
                </div>
                <div class="left-menu-item">
                    <a href="<c:url value="/monitor/list" />">Monitors</a>
                </div>
                <div style="margin-top: 15px; background-color: #FFF8DC">
                    &nbsp;
                </div>
                <div class="left-menu-item" >
                    <a href="<c:url value="/host/add" />">Add host</a>
                </div>
                <div class="left-menu-item" >
                    <a href="<c:url value="/service/add" />">Add service</a>
                </div>
            </div>
            <div class="view-content">
                <jsp:doBody />
            </div>
        </div>
    </body>
</html>
