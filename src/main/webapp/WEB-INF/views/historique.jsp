<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/csspp.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/cssb.css" rel="stylesheet" type="text/css"/>
        <c:import url="_STYLESHEET.jsp"/>            
    </head>
    <body>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu">
            <table>
                <thead>
                    <tr>
                        <th width="150" style="text-align: center">Pseudo</th>
                        <th width="150" style="text-align: center">Nom</th>
                        <th width="150" style="text-align: center">Prenom</th>
                        <th width="150" style="text-align: center">Adresse</th>
                        <th width="150" style="text-align: center">Mail</th>
                        <th width="150" style="text-align: center">Moyenne note</th>
                    </tr>
                </thead>
                    <tbody>
                        <tr>
                            <td style="text-align: center">${personne.login}</td>
                            <td style="text-align: center">${personne.nom}</td>
                            <td style="text-align: center">${personne.prenom}</td>
                            <td style="text-align: center">${personne.adresse}</td>
                            <td style="text-align: center">${personne.mail}</td>
                            <td style="text-align: center">${personne.noteGlobale}</td>
                        </tr>
                    </tbody>
                    <thead>
                        <th width="150" style="text-align: center">Courses</th>
                        <c:if test="${connecte.rolePersonne=='CHAUFFEUR'}">
                            <th width="150" style="text-align: center">Marque véhicule</th>
                            <th width="150" style="text-align: center">Modèle véhicule</th>
                            <th width="150" style="text-align: center">Immatriculation véhicule</th>
                        </c:if>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="text-align: center">
                                <c:forEach items="${courses}" var="course">
                                    <li><a href="detail_course/${course.idCourse}">${course.dateCourse}</a></li>
                                </c:forEach></td>
                        <c:if test="${connecte.rolePersonne=='CHAUFFEUR'}">
                            <td style="text-align: center">${vehicule.marque}</td>
                            <td style="text-align: center">${vehicule.modele}</td>
                            <td style="text-align: center">${vehicule.immatriculation}</td>
                            <td style="text-align: center"><a href="detailVehicule/${vehicule.idVehicule}">Fiche technique véhicule</a></td>
                            <td style="text-align: center"><a href="ajouterVehicule">Ajouter un véhicule</a></td>
                        </c:if></tr>
                    </tbody>
                </table>
            </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
