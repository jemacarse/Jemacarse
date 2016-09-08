<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBeiB8cFZ4OfoOXsc9PXNXnSzlrQKf1XKI&language=fr"></script>
        <script type="text/javascript" src="<spring:url value="/JS/jquery.min.js"/>"></script>
        <script type="text/javascript" src="<spring:url value="/JS/jquery-ui-1.8.12.custom.min.js"/>"></script>
        <script type="text/javascript" src="<spring:url value="/JS/functions.js"/>"></script>
        <link rel="stylesheet" href="JS/jquery-ui-1.8.12.custom.css" type="text/css" />
        <link href="CSS/cssb.css" rel="stylesheet" type="text/css"/>
        <c:import url="_STYLESHEET.jsp"/> 
    </head>
    <body>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
            <div id="destinationForm">
                Destination : <input type="text" name="destination" id="destination">
                    <input type="button" value="Calculer l'itinéraire" onclick="javascript:calculate()">
            </div>
        </div>
        <div class="map">
            <div id="container">
                <div id="map" style = "width:100%; height:900px;"></div>
            </div>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
