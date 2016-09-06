package jemacarse.controller;

import javax.servlet.http.HttpSession;
import jemacarse.entity.Personne;
import jemacarse.entity.Vehicule;
import jemacarse.entity.Vehicule.TypeVehicule;
import jemacarse.service.PersonneCrudService;
import jemacarse.service.VehiculeCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehiculeController {
    
    @Autowired
    private VehiculeCrudService vehiculeCrudService;
    
    @Autowired
    private PersonneCrudService personneCrudService;
    
    @RequestMapping(value = "/ajouter_vehicule/{idVehicule}", method = RequestMethod.GET)
    public String modifVehiculeGET(Model m, @PathVariable long idVehicule) {
        
        Vehicule v = vehiculeCrudService.findOne(idVehicule);
        
        m.addAttribute("ajoutVehicule", v);
        m.addAttribute("typeVehicule", v.getTypeVehicule().getClass());
        
        return "ajouter_vehicule";
    }
    
    @RequestMapping(value = "/ajouter_vehicule/{idVehicule}", method = RequestMethod.POST)
    public String modifVehiculePOST(@ModelAttribute("ajoutVehicule") Vehicule v, HttpSession session) {
        
        v.setDisponibilite(Vehicule.Disponibilite.LIBRE);
        Personne p  = ((Personne)session.getAttribute("connecte"));
        vehiculeCrudService.save(v);
        p.setVehicule(v);
        personneCrudService.save(p);
        
        return "redirect:/historique";
    }
    
    @RequestMapping(value = "/ajouter_vehicule", method = RequestMethod.GET)
    public String ajoutVehiculeGET(Model m) {
        
        Vehicule v = new Vehicule();
        m.addAttribute("ajoutVehicule", v);
        m.addAttribute("typeVehicule", TypeVehicule.values());
        
        return "ajouter_vehicule";
    }
    
    @RequestMapping(value = "/ajouter_vehicule", method = RequestMethod.POST)
    public String ajoutVehiculePOST(@ModelAttribute("ajoutVehicule") Vehicule v, HttpSession session) {
        
        v.setDisponibilite(Vehicule.Disponibilite.LIBRE);
        Personne p  = ((Personne)session.getAttribute("connecte"));
        vehiculeCrudService.save(v);
        p.setVehicule(v);
        personneCrudService.save(p);
        
        if (session.getAttribute("connecte") != null){
            return "redirect:/geolocalisation";
        }
        
        return "redirect:/accueil";
    }
    
    @RequestMapping(value = "/detail_vehicule/{idVehicule}", method = RequestMethod.GET)
    public String detailVehiculeGET(Model m, @PathVariable long idVehicule) {
        
        Vehicule v = vehiculeCrudService.findOne(idVehicule);
        m.addAttribute("vehicule", v);
        
        return "detail_vehicule";
    }
    
    @RequestMapping(value = "/dispo", method = RequestMethod.GET)
    public String modifDisponibilite(HttpSession session) {
        
        Personne p  = ((Personne)session.getAttribute("connecte"));
        Vehicule v = p.getVehicule();
        
        if (v.getDisponibilite().equals(Vehicule.Disponibilite.LIBRE)){
            v.setDisponibilite(Vehicule.Disponibilite.OCCUPE);
            vehiculeCrudService.save(v);
            return "redirect:/geolocalisation";}
        
        v.setDisponibilite(Vehicule.Disponibilite.LIBRE);
        vehiculeCrudService.save(v);
        
        return "redirect:/geolocalisation";
    }
}
