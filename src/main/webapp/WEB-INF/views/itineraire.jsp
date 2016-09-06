<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBeiB8cFZ4OfoOXsc9PXNXnSzlrQKf1XKI&language=fr"></script>
        <script type="text/javascript" src="<spring:url value="JS/jquery.min.js"/>"></script>
        <script type="text/javascript" src="<spring:url value="JS/jquery-ui-1.8.12.custom.min.js"/>"></script>
        <script type="text/javascript" src="<spring:url value="JS/functions.js"/>"></script>
        <link rel="stylesheet" href="JS/jquery-ui-1.8.12.custom.css" type="text/css" />
        <link href="CSS/cssb.css" rel="stylesheet" type="text/css"/>
        <c:import url="_STYLESHEET.jsp"/> 
    </head>
    <!--    <style type="text/css">
        body{font-family:Arial;background:#000000;margin:0px;padding:0px;}
        #container{position:relative;width:990px;margin:auto;background:#FFFFFF;padding:20px 0px 20px 0px;}
        #container h1{margin:0px 0px 10px 20px;}
        #container #map{width:700px;height:500px;margin:auto;}
        #container #panel{width:700px;margin:auto;}
        #container #destinationForm{margin:0px 0px 20px 0px;background:#EEEEEE;padding:10px 20px;border:solid 1px #C0C0C0;}
        #container #destinationForm input[type=text]{border:solid 1px #C0C0C0;}
      </style>-->
    <body>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu">
            <div id="container">
                <div id="destinationForm">
                    <form:form modelAttribute="course" name="direction" id="direction">
                        Destination : <input type="text" name="destination" id="destination">
                        Distance : <form:input path="distance" type="text" name="distance_trajet" id="distance_trajet"></form:input>
                        Durée : <input type="text" name="duree_trajet" id="duree_trajet">
                        Adresse depart : <form:input path="adresseDepartClient" type="text" name="adresseDepart" id="adresseDepart"></form:input>
                        Adresse Arrivée : <form:input path="adresseArrivee" type="text" name="adresseArrivee" id="adresseArrivee"></form:input>
                        <input type="button" value="Calculer l'itinéraire" onclick="javascript:calculate()">
                    </form:form>
                </div>
                <div id="map" style = "width:100%; height:900px;"></div>
                <p>Veuillez patienter pendant le chargement de la carte...</p>
            </div>
            <div id="directions_panel"></div>
            <div id="panel"></div>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
