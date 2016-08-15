<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${persoConnecte.rolePersonne=='CLIENT'}">
    <a href="connexion">Déconnexion client</a>
</c:if>
<c:if test="${persoConnecte.rolePersonne=='CHAUFFEUR'}">
    <a href="connexion">Déconnexion chauffeur</a>
</c:if>
