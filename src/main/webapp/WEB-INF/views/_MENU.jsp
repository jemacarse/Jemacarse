<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="../../JS/jemacarse.js" type="text/javascript"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul id="menu_horizontal">
    <c:choose>
        <c:when test="${connecte==null}">
            Veuillez vous connecter ou vous inscrire
        </c:when>
        <c:when test="${connecte==CHAUFFEUR}">
            <li><a href="ajout_vehicule">Definir un véhicule</a></li>
            <li><a href="itineraire"><img src="PNG/LOGO.png" width="70" alt=""/></a></li>
            <c:if test="${connecte==vehicule.LIBRE}">
                <li><a href="dispo"><img src="PNG/DISPONIBLE.png" width="70" alt=""/></a></li>
            </c:if>
            <c:if test="${connecte==vehicule.OCCUPE}">
                <li><a href="dispo"><img src="PNG/INDISPONIBLE.png" width="70" alt=""/></a></li>
            </c:if>
        </c:when>
        <c:otherwise>
            <label>Jemacarse Vite fait, bien fait !!</label>
            <li><a href="historique"><img src="PNG/HISTORIQUE.PNG" width="45" alt=""/></a></li>
            <li><a href="itineraire"><img src="PNG/LOGOCLIENT.png" width="70" alt=""/></a></li>
            <li><a href="deconnexion"><img src="PNG/GNOME.png" width="35" alt=""/></a></li>
            <li>Bonjour ${connecte.login}</li>
            <li><a href="geolocalisation">Accueil</a></li>
            <li><a href="test/LIBRE">test DISPO</a></li>
            </c:otherwise>
        </c:choose>
</ul>