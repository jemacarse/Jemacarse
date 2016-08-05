<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JemaCARse</title>
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
            <h1>Log in</h1>
            <form method="post">
                <label for="login">Login :</label>
                <input name="login" type="text" width="150">
                <br />
                <br />
                <label for="motDePasse">Mot de Passe :</label>
                <input name="motDePasse" type="password" width="400">
                <br />
                <br />
                <input type="submit" value="Valider">
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>

