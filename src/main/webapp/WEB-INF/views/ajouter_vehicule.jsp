<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/csspp.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouveau véhicule</title>
        <c:import url="_STYLESHEET.jsp"/>            
    </head>
    <body>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu">
            <h1>Nouveau véhicule :</h1>
                <form:form modelAttribute="ajoutVehicule">
                    Entrez la marque du véhicule :<form:input path="marque"></form:input>
                    <br />
                    <br />
                    Entrez le modèle du véhicule :<form:input path="modele"></form:input>
                    <br />
                    <br />
                    Entrez l'immatriculation du véhicule :<form:input path="immatriculation"></form:input>
                    <br />
                    <br />
                    Entrez le nombre de places :<form:input path="nbPlaces"></form:input>
                    <br />
                    <br />
                    Définissez le type du véhicule :<form:select path="typeVehicule" items="${typeVehicule}"></form:select>
                    <br />
                    <br />
                    Définissez le prix au km :<form:input path="prixParKm"></form:input>
                    <br />
                    <br />
                    <input type="submit" value="Ajouter"/>
                </form:form>
            </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>