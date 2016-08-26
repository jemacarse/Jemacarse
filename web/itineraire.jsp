<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBeiB8cFZ4OfoOXsc9PXNXnSzlrQKf1XKI&signed_in=true&callback=initMap"></script>
        <script type="text/javascript" src="JS/jemacarse.js"></script>
    </head>
    <body>
        <div id="destinationForm">
            <form action="" method="get" name="direction" id="direction">
                <label>Destination :</label>
                <input type="text" name="destination" id="destination">
                <input type="button" value="Calculer l'itinéraire" onclick="javascript:calcul()">
            </form>
        </div>
        <div id="panel"></div>
    </body>
</html>
