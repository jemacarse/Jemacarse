function loadMap() {

    var mapOptions = {
        center: new google.maps.LatLng(50.606447, 3.152580),
        zoom: 15,
        streetViewControl: false,
    }

    var map = new google.maps.Map(document.getElementById("sample"), mapOptions);

    var marker = new google.maps.Marker({
        position: new google.maps.LatLng(50.606447, 3.152580),
        map: map,
        draggable: true,
        icon: 'PNG/CLIENT_PNG.PNG',
        title: 'Votre position actuelle'
    });

    var infoWindow = new google.maps.InfoWindow({map: map});


    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            infoWindow.setPosition(pos);
            infoWindow.setContent('Location found.');
            map.setCenter(pos);
        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
            'Erreur: The Geolocation service failed.' :
            'Erreur: Votre navigateur ne supporte pas la géolocalisation');

}


