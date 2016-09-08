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
                            <th width="150" style="text-align: center">Date</th>
                            <c:if test="${connecte.rolePersonne=='CLIENT'}">
                                <th width="150" style="text-align: center">Chauffeur</th>
                            </c:if>
                            <c:if test="${connecte.rolePersonne=='CHAUFFEUR'}">
                                <th width="150" style="text-align: center">Clients</th>
                            </c:if>
                            <th width="150" style="text-align: center">Commentaire reçu</th>
                            <th width="150" style="text-align: center">Commentaire donné</th>
                            <th width="150" style="text-align: center">Note reçu</th>
                            <th width="150" style="text-align: center">Note donné</th>    
                            <th width="150" style="text-align: center">Montant</th>
                            <th width="150" style="text-align: center">Distance</th>
                            <th width="150" style="text-align: center">Statut de la course</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="text-align: center">${course.dateCourse}</td>
                            <c:if test="${connecte.rolePersonne=='CLIENT'}">
                                <td style="text-align: center"><a href="../detail_chauffeur/${chauffeur.idPersonne}">${chauffeur.login}</a></td>
                                <td style="text-align: center">${course.commentaireChauffeur}</td>
                                <td style="text-align: center">${course.commentaireClient}</td>
                                <td style="text-align: center">${course.noteChauffeur}</td>
                                <td style="text-align: center">${course.noteClient}</td>
                            </c:if>
                            <c:if test="${connecte.rolePersonne=='CHAUFFEUR'}">
                                <td style="text-align: center"><a href="../detail_client/${client.idPersonne}">${client.login}</a></td>
                                <td style="text-align: center">${course.commentaireClient}</td>
                                <td style="text-align: center">${course.commentaireChauffeur}</td>
                                <td style="text-align: center">${course.noteClient}</td>
                                <td style="text-align: center">${course.noteChauffeur}</td>
                            </c:if>
                            <td style="text-align: center">${course.montant}</td>
                            <td style="text-align: center">${course.distance}</td>
                            <td style="text-align: center">${course.etatCourse}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
