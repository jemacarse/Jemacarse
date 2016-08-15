<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBeiB8cFZ4OfoOXsc9PXNXnSzlrQKf1XKI&signed_in=true&callback=initMap"></script>
        <script type="text/javascript" src="JS/jemacarse.js"></script>
    </head>
    <body onload = "loadMap()">
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
      <div id = "sample" style = "width:1280px; height:800px;"></div>
    </body>
</html>
