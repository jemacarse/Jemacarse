<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                            <td style="text-align: center"><a href="<spring:url value="/modif_infoPerso/${personne.idPersonne}"/>">Modifier information personnelle</a></td>
                        </tr>
                    </tbody>
                    </table>
                    <table>
                    <thead>
                        <th width="250" style="text-align: center">Courses</th>
                        <th width="250" style="text-align: center">Statut course</th>
                        <c:if test="${connecte.rolePersonne=='CHAUFFEUR'}">
                            <th width="250" style="text-align: center">Marque véhicule</th>
                            <th width="250" style="text-align: center">Modèle véhicule</th>
                        </c:if>
                    </thead>
                        <tbody>
                            <tr>
                            <c:forEach items="${courses}" var="coursePers"><tr>
                                    <td style="text-align: center"><a href="<spring:url value="/detail_course/${coursePers.idCourse}"/>">${coursePers.dateCourse}</a></td>
                                    <td style="text-align: center">${coursePers.etatCourse}</td>
                                </c:forEach></tr>
                            <tr><c:if test="${course.etatCourse == 'IMPAYE'}">
                                <td style="text-align: center">${course.dateCourse}</td>
                                <td style="text-align: center">${coursePers.etatCourse}</td>
                                <td style="text-align: center"><a href="<spring:url value="/statutCourse"/>">Payer</a></td>
                            </c:if></tr>
                            <c:if test="${connecte.rolePersonne=='CHAUFFEUR'}">
                                <td style="text-align: center">${personne.vehicule.marque}</td>
                                <td style="text-align: center">${personne.vehicule.modele}</td>
                                <td style="text-align: center"><a href="<spring:url value="/detail_vehicule/${personne.vehicule.idVehicule}"/>">Fiche technique véhicule</a></td>
                            </c:if>
                        </tr>
                    </tbody>
                </table>
            </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
