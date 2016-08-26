<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBeiB8cFZ4OfoOXsc9PXNXnSzlrQKf1XKI&signed_in=true&callback=initMap"></script>
        <script src="<spring:url value="/JS/jemacarse.js"/>"></script>
        <link href="CSS/cssb.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload = "loadMap()">
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
      <div id = "sample" style = "width:1280px; height:800px;"></div>
    </body>
</html>