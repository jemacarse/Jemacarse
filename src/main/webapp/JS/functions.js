var map;
var panel;
var initialize;
var calculate;
var direction;

function startWatch() {
    if (navigator.geolocation)
        //var watchId = navigator.geolocation.watchPosition(successCallback,
        var watchId = navigator.geolocation.getCurrentPosition(successCallback,
                errorCallback,
                {enableHighAccuracy: true,
                    timeout: 100000});  //,
    //maximumAge:3000000});
    else
        alert("Votre navigateur ne prend pas en compte la géolocalisation HTML5");
}


function successCallback(position) {
    initialize(position);
//            document.getElementById("lat").innerHTML = position.coords.latitude;
//            document.getElementById("long").innerHTML = position.coords.longitude;
//            document.getElementById("prec").innerHTML = position.coords.accuracy;
//            document.getElementById("alt").innerHTML = position.coords.altitude;
//            document.getElementById("precalt").innerHTML = position.coords.altitudeAccuracy;
//            document.getElementById("angle").innerHTML = position.coords.heading;
//            document.getElementById("speed").innerHTML = position.coords.speed;
//            document.getElementById("time").innerHTML = new Date(position.timestamp);
}
;
function errorCallback(error) {
    switch (error.code) {
        case error.PERMISSION_DENIED:
            alert("L'utilisateur n'a pas autorisé l'accès à sa position");
            break;
        case error.POSITION_UNAVAILABLE:
            alert("L'emplacement de l'utilisateur n'a pas pu être déterminé");
            break;
        case error.TIMEOUT:
            alert("Le service n'a pas répondu à temps");
            break;
    }
}
;

initialize = function (position) {

    //var latLng = new google.maps.LatLng(50.6371834, 3.063017400000035); // Correspond au coordonnées de Lille
    var latLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
    //alert(latLng);
    var myOptions = {
        zoom: 14, // Zoom par défaut
        center: latLng, // Coordonnées de départ de la carte de type latLng 
        mapTypeId: google.maps.MapTypeId.TERRAIN, // Type de carte, différentes valeurs possible HYBRID, ROADMAP, SATELLITE, TERRAIN
        maxZoom: 20
    };

    map = new google.maps.Map(document.getElementById('map'), myOptions);
    panel = document.getElementById('panel');

    var marker = new google.maps.Marker({
        position: latLng,
        map: map,
        title: "Vous êtes ici",
        icon: "PNG/CLIENT.PNG" // Chemin de l'image du marqueur pour surcharger celui par défaut
    });

    var contentMarker = [
        '<div id="containerTabs">',
        '<div id="tabs">',
        '<ul>',
        '<li><a href="#tab-1"><span>Lorem</span></a></li>',
        '<li><a href="#tab-2"><span>Ipsum</span></a></li>',
        '<li><a href="#tab-3"><span>Dolor</span></a></li>',
        '</ul>',
        '<div id="tab-1">',
        '<h3>Lille</h3><p>Suspendisse quis magna dapibus orci porta varius sed sit amet purus. Ut eu justo dictum elit malesuada facilisis. Proin ipsum ligula, feugiat sed faucibus a, <a href="http://www.google.fr">google</a> sit amet mauris. In sit amet nisi mauris. Aliquam vestibulum quam et ligula pretium suscipit ullamcorper metus accumsan.</p>',
        '</div>',
        '<div id="tab-2">',
        '<h3>Aliquam vestibulum</h3><p>Aliquam vestibulum quam et ligula pretium suscipit ullamcorper metus accumsan.</p>',
        '</div>',
        '<div id="tab-3">',
        '<h3>Pretium suscipit</h3><ul><li>Lorem</li><li>Ipsum</li><li>Dolor</li><li>Amectus</li></ul>',
        '</div>',
        '</div>',
        '</div>'
    ].join('');

    var infoWindow = new google.maps.InfoWindow({
        content: contentMarker,
        position: latLng
    });

    google.maps.event.addListener(marker, 'click', function () {
        infoWindow.open(map, marker);
    });

    google.maps.event.addListener(infoWindow, 'domready', function () { // infoWindow est biensûr notre info-bulle
        jQuery("#tabs").tabs();
    });


    direction = new google.maps.DirectionsRenderer({
        map: map,
        //panel: panel // Dom element pour afficher les instructions d'itinéraire
    }

    );
    
    //alert("origine : " + origin + "; destination : " + destination );
    
    
    
//    computeTotalDistance(direction.getDirections());
//
//
//    function computeTotalDistance(result) {
//        var total = 0;
//        var myroute = result.routes[0];
//        for (var i = 0; i < myroute.legs.length; i++) {
//            total += myroute.legs[i].distance.value;
//        }
//        total = total / 1000;
//        document.getElementById('distance_trajet').innerHTML = total + ' km';
//    };

};

//function calcDistance(p1, p2) {
//    alert(p1 + " :: " + p2);
//     return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
//    };
    
calculate = function () {
    //origin      = document.getElementById('origin').value; // Le point départ
    origin = map.getCenter();
    alert(origin);
    destination = document.getElementById('destination').value; // Le point d'arrivé
    if (origin && destination) {
        var request = {
            origin: origin,
            destination: destination,
            travelMode: google.maps.DirectionsTravelMode.DRIVING // Mode de conduite
        };
        var directionsService = new google.maps.DirectionsService(); // Service de calcul d'itinéraire
        directionsService.route(request, function (response, status) { // Envoie de la requête pour calculer le parcours
            if (status == google.maps.DirectionsStatus.OK) {
                direction.setDirections(response); // Trace l'itinéraire sur la carte et les différentes étapes du parcours
                alert("Réponse Ok de google");
                //alert(calcDistance(origin, origin));
                var route = response.routes[0];
            //  alert(route.legs[1].duration.text);
            var summaryPanel = document.getElementById('directions_panel');
            summaryPanel.innerHTML = '';
            // For each route, display summary information.
            var distance_totale = 0;
            var duree_totale = 0;
            for (var i = 0; i < route.legs.length; i++) {
            var routeSegment = i + 1;
            summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment + '</b><br>';
            summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
            summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
            summaryPanel.innerHTML += route.legs[i].duration.text + '<br>';
            summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
            //alert(route.legs[i].duration.t + "###" + route.legs[i].distance);
            distance_totale = distance_totale + route.legs[i].distance.value;
            duree_totale = duree_totale + route.legs[i].duration.value;
            document.getElementById('adresseDepart').value = route.legs[i].start_address;
            document.getElementById('adresseArrivee').value = route.legs[i].end_address;
            
            $.ajax({
                url : 'itineraire',
                type : 'POST', 
                data : 'adresseDepart=' + route.legs[i].start_address + 'adresseArrivee=' + route.legs[i].end_address,
                dataType : 'json',
                success : function(code_html, statut){ 
                 },
                error : function(resultat, statut, erreur){
                }
            });
            
            }
            //alert("distance totale =" + distance_totale);
            //alert("duree totale =" + duree_totale);
            document.getElementById('distance_trajet').value = (Math.floor(distance_totale / 1000)) + "," + (distance_totale % 1000) + " km";
            document.getElementById('duree_trajet').value = (Math.floor(duree_totale / 60)) + " m " + (duree_totale % 60) + " s";
            
            
        }});
}};

//initialize();

startWatch();
