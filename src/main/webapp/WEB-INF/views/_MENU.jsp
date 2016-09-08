<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="../../JS/jemacarse.js" type="text/javascript"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<ul id="menu_horizontal">
    <c:choose>
        <c:when test="${connecte == null}">
            Veuillez vous connecter ou vous inscrire
        </c:when>
        <c:when test="${connecte.rolePersonne == 'CHAUFFEUR'}">
            <label>Jemacarse Vite fait, bien fait !!</label>
            <li><a href="<spring:url value="/historique"/>"><img src="<spring:url value="/PNG/HISTORIQUE.PNG"/>" width="45" alt=""/></a></li>
            <li><a href="<spring:url value="/deconnexion"/>"><img src="<spring:url value="/PNG/DECONNEXION.png"/>" width="35" alt=""/></a></li>
            <c:if test="${connecte.vehicule.disponibilite == 'LIBRE'}">
                <li><a href="<spring:url value="/dispo"/>"><img src="<spring:url value="/PNG/DISPONIBLE.PNG"/>" width="35" alt=""/></a></li>
            </c:if>
            <c:if test="${connecte.vehicule.disponibilite == 'OCCUPE'}">
                <li><a href="<spring:url value="/dispo"/>"><img src="<spring:url value="/PNG/INDISPONIBLE.PNG"/>" width="35" alt=""/></a></li>
            </c:if>
            <li>Bonjour ${connecte.login}</li>
            <li><a href="<spring:url value="/geolocalisation"/>">Accueil</a></li>
        </c:when>
        <c:otherwise>
            <label>Jemacarse Vite fait, bien fait !!</label>
            <li><a href="<spring:url value="/historique"/>"><img src="<spring:url value="/PNG/HISTORIQUE.PNG"/>" width="45" alt=""/></a></li>
            <li><a href="<spring:url value="/itineraire"/>"><img src="<spring:url value="/PNG/LOGOCLIENT.png"/>" width="70" alt=""/></a></li>
            <li><a href="<spring:url value="/deconnexion"/>"><img src="<spring:url value="/PNG/DECONNEXION.png"/>" width="35" alt=""/></a></li>
            <c:if test="${course.etatCourse == 'IMPAYE'}">
                <li><a href="<spring:url value="/statutCourse"/>"><img src="<spring:url value="/PNG/PAYER.png"/>" width="35" alt=""/></a></li>
            </c:if>
            <li>Bonjour ${connecte.login}</li>
        </c:otherwise>
    </c:choose>
</ul>