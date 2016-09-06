package jemacarse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapController {
    
    
    
    @RequestMapping(value = "/geolocalisation", method = RequestMethod.GET)
    public String geolocalisationSurMap (Model m){
        
        return "geolocalisation";
    }
}
