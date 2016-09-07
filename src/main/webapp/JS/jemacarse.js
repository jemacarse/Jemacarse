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
    };

    var map = new google.maps.Map(document.getElementById("sample"), mapOptions);

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pos = {
                enableHighAccuracy: true,
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

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
}