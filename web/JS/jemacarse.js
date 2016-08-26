function loadMap() {

    var mapOptions = {
        center: new google.maps.LatLng(50.606447, 3.152580),
        zoom: 15,
        panControl: false,
        zoomControl: true,
        scaleControl: false,
        mapTypeControl: false,
        streetViewControl: false,
        overviewMapControl: false,
        rotateControl: false
    }
    
    var map = new google.maps.Map(document.getElementById("sample"), mapOptions);

    var infoWindow = new google.maps.InfoWindow({map: map});

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            infoWindow.setPosition(pos);
            infoWindow.setContent('Localisation trouvée');
            map.setCenter(pos);

            var marker = new google.maps.Marker({
                position: pos,
                map: map,
                draggable: false,
                icon: 'PNG/CLIENT.PNG',
                title: 'Votre position actuelle'
            });
        }, function () {
            erreurLocalisation(true, infoWindow, map.getCenter());
        });
    } else {

        erreurLocalisation(false, infoWindow, map.getCenter());
    }


function erreurLocalisation(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
            'Erreur: La geolocalisation à échoué.' :
            'Erreur: Votre navigateur ne supporte pas la géolocalisation');
}

    var panel;
    var initialize;
    
    var direction;
    
    
    direction = new google.maps.DirectionsRenderer({
    map   : map, 
    panel : panel 
    });
    
function calcul(){
    origin      = pos;
    destination = document.getElementById('destination').value;
    console.log(pos);
    console.log(destination)
    
    if(origin && destination){
        var request = {
            origin      : origin,
            destination : destination,
            travelMode  : google.maps.DirectionsTravelMode.DRIVING 
        }
        var directionsService = new google.maps.DirectionsService(); 
        directionsService.route(request, function(response, status){ 
            if(status == google.maps.DirectionsStatus.OK){
                direction.setDirections(response); 
            }
        });
    } 
};

}