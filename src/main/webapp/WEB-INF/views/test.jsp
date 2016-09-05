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
                        <th width="150" style="text-align: center">Disponibilite</th>
                    </tr>
                </thead>
                    <tbody>
                        <tr>
                            <c:forEach items="${personne}" var="personne">
                                <td style="text-align: center">${personne.vehicule.disponibilite}</td>
                            </c:forEach>
                        </tr>
                    </tbody>
                </table>
            </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
