<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="_STYLESHEET.jsp"/>            
    </head>
    <body>
        <div class="titre">
            <c:import url="_TITRE.jsp"/>
        </div>
        <div class="menu">
             <c:import url="_CONNEXION.jsp"/>
        </div>
        <div class="contenu">
            <h1>Inscription</h1>
            <form method="post">
                <label for="login">Entrez un login utilisateur :</label>
                <input name="login" type="text" width="150">
                <br />
                <br />
                <label for="motDePasse">Tapez un mot de Passe :</label>
                <input name="motDePasse" type="password" width="400">
                <br />
                <br />
                <label for="motDePasse2">Retapez votre Mot de Passe :</label>
                <input name="motDePasse2" type="password" width="400">
                <br />
                <br />
                <label for="nom">Entrez votre Nom :</label>
                <input name="nom" type="text" width="400">
                <br />
                <br />
                <label for="prenom">Entrez votre prénom :</label>
                <input name="prenom" type="text" width="400">
                <br />
                <br />
                <label for="adresse">Entrez une adresse :</label>
                <input name="adresse" type="text" width="400">
                <br />
                <br />
                Client :<input name="type" type="radio" value="CLIENT">Chauffeur :<input name="type" type="radio" value="CHAUFFEUR">
                <input type="submit" value="Valider">
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
