<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/csspp.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
        <c:import url="_STYLESHEET.jsp"/>            
    </head>
    <body>
        <div class="titre">
            <c:import url="_TITRE.jsp"/>
        </div>
        <div class="global">
            <div class="inscription">
                <h1>Inscription</h1>
                <form:form modelAttribute="inscription" action="inscription">
                    Entrez un login utilisateur :<form:input path="login"></form:input>
                    <br />
                    <br />
                    Tapez un mot de Passe :<form:password path="motDePasse"></form:password>
                    <br />
                    <br />
                    Retapez votre Mot de Passe :<form:password path="motDePasse2"></form:password>
                    <br />
                    <br />
                    Entrez votre Nom :<form:input path="nom"></form:input>
                    <br />
                    <br />
                    Entrez votre prénom :<form:input path="prenom"></form:input>
                    <br />
                    <br />
                    Entrez une adresse :<form:input path="adresse"></form:input>
                    <br />
                    <br />
                    Entrez votre e-mail :<form:input path="mail"></form:input>
                    <br />
                    <br />
                    <form:radiobuttons path="rolePersonne" items="${rolePersonne}"></form:radiobuttons>
                    <input type="submit" value="OK"/>
                    </div>
                </form:form>
                <div class="connexion">
                    <h2>Log in</h2>
                    <form:form modelAttribute="connexion" action="connexion">
                        Login :<form:input path="login"></form:input>
                        <br />
                        <br />
                        Mot de Passe :<form:password path="motDePasse"></form:password>
                        <br />
                        <br />
                        <input type="submit" value="OK"/>
                    </form:form>
                </div>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>