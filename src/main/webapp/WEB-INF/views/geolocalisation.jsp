<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBeiB8cFZ4OfoOXsc9PXNXnSzlrQKf1XKI&language=fr"></script>
        <script src="<spring:url value="JS/jemacarse.js"/>"></script>
        <link href="CSS/cssb.css" rel="stylesheet" type="text/css"/>
        <title>Jemacarse, Vite fait, Bien fait !!</title>
        <c:import url="_STYLESHEET.jsp"/> 
    </head>
    <body onload = "loadMap()">
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="map">
            <div id = "sample" style = "width:100%; height:900px;"></div>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>