<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${UtilConnecte.typeUtil=='CLIENT'}">
    <a href="panier">Voir panier</a>
    <a href="liste_articles">Revenir à la liste</a>
    <a>Vous avez ${nombreArticles} articles dans votre panier</a>
    <a href="login">Déconnexion</a>
</c:if>
<c:if test="${UtilConnecte.typeUtil=='EXPEDITION'}">
    Voir commandes <a href="commandeATraite">A traiter</a> & <a href="commandesExpedie">Expédiées</a>
    <a href="liste_articles">Revenir à la liste</a>
    <a href="login">Déconnexion</a>
</c:if>
<c:if test="${UtilConnecte.typeUtil=='ADMIN'}">
    <a href="panier">Voir panier</a>
    <a href="liste_articles">Revenir à la liste</a>
    Voir commandes <a href="commandeATraite">A traiter</a> & <a href="commandesExpedie">Expédiées</a>
    <a>Vous avez ${nombreArticles} articles dans votre panier</a>
    <a href="ajout_article">Ajouter nouvel article</a>
    <a href="login">Déconnexion</a>
</c:if>