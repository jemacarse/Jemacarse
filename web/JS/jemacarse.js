function loadMap() {

    var mapOptions = {
        center: new google.maps.LatLng(50.606447, 3.152580),
        zoom: 15,
        panControl: false,
        zoomControl: true,
        scaleControl: false,
        mapTypeControl: true,
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
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {

        handleLocationError(false, infoWindow, map.getCenter());
    }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
            'Erreur: The Geolocation service failed.' :
            'Erreur: Votre navigateur ne supporte pas la géolocalisation');

}


