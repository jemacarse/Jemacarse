var map;
var panel;
var initialize;
var calculate;
var direction;

direction = new google.maps.DirectionsRenderer({
    map: map,
    panel: panel
});

calculate = function () {
    origin = document.getElementById('origin').value; // Le point départ
    destination = document.getElementById('destination').value; // Le point d'arrivé
    if (origin && destination) {
        var request = {
            origin: origin,
            destination: destination,
            travelMode: google.maps.DirectionsTravelMode.DRIVING // Type de transport
        }
        var directionsService = new google.maps.DirectionsService(); // Service de calcul d'itinéraire
        directionsService.route(request, function (response, status) { // Envoie de la requête pour calculer le parcours
            if (status == google.maps.DirectionsStatus.OK) {
                direction.setDirections(response); // Trace l'itinéraire sur la carte et les différentes étapes du parcours
            }
        });
    }
};