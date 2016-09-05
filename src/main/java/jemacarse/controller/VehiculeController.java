/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jemacarse.controller;

import jemacarse.entity.Vehicule;
import jemacarse.entity.Vehicule.TypeVehicule;
import jemacarse.service.VehiculeCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */
public class VehiculeController {
    
    @Autowired
    private VehiculeCrudService vehiculeCrudService;
    
    @RequestMapping(value = "/ajouter_vehicule", method = RequestMethod.GET)
    public String ajoutVehiculeGET(Model m) {
        
        Vehicule v = new Vehicule();
        
        m.addAttribute("ajoutVehicule", v);
        m.addAttribute("typeVehicule", TypeVehicule.values());

        return "ajouter_vehicule";
    }
    
    @RequestMapping(value = "/ajouter_vehicule", method = RequestMethod.POST)
    public String ajoutVehiculePOST(@ModelAttribute("ajoutVehicule") Vehicule v) {

        vehiculeCrudService.save(v);
            
        return "historique";
    }
}
