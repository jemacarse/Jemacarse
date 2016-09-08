<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/csspp.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier information personnelle</title>
        <c:import url="_STYLESHEET.jsp"/>            
    </head>
    <body>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu">
            <h1>Modifier information personnelle :</h1>
                <form:form modelAttribute="modifPerso">
                    Tapez un nouveau mot de Passe :<form:password path="motDePasse"></form:password>
                    <br />
                    <br />
                    Retapez votre Mot de Passe :<form:password path="motDePasse2"></form:password>
                    <br />
                    <br />
                    Entrez une adresse :<form:input path="adresse"></form:input>
                    <br />
                    <br />
                    Entrez votre e-mail :<form:input path="mail"></form:input>
                    <br />
                    <br />
                    <input type="submit" value="Modifier"/>
                </form:form>
            </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>