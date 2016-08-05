var centerpos = new google.maps.LatLng(50.606229, 3.152194);

// Options relatives à la carte
var optionsGmaps = {
    center:centerpos,
    mapTypeId: google.maps.MapTypeId.ROADMAP,
    zoom: 15
};
// ROADMAP peut être remplacé par SATELLITE, HYBRID ou TERRAIN
// Zoom : 0 = terre entière, 19 = au niveau de la rue
 
// Initialisation de la carte pour l'élément portant l'id "map"
var map = new google.maps.Map(document.getElementById("map"), optionsGmaps);
  
// .. et la variable qui va stocker les coordonnées
var latlng;