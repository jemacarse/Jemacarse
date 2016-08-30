package jemacarse.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import jemacarse.entity.Course;
import jemacarse.entity.Personne;
import jemacarse.entity.Personne.RolePersonne;
import jemacarse.entity.Vehicule;
import jemacarse.service.CourseCrudService;
import jemacarse.service.PersonneCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonneController {

    @Autowired
    private PersonneCrudService personneCrudService;
    
    @Autowired
    private CourseCrudService courseCrudService;

    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET) //------------------------------------------------- Deconnexion
    public String deconnexion(HttpSession session) {

        session.invalidate();
        
        return "redirect:/accueil";
    }
    
    @RequestMapping(value = "/connexion", method = RequestMethod.POST) //---------------------------------------------------- Connexion
    public String connexionPOST(@ModelAttribute("connexion") Personne p, HttpSession session) {

        Personne personneTrouvee = personneCrudService.findOneByLoginAndMotDePasse(p.getLogin(), p.getMotDePasse());
        
        if (personneTrouvee != null) {
            session.setAttribute("connecte", personneTrouvee);
            return "redirect:/geolocalisation";
        }
        return "redirect:/accueil";
    }

    @RequestMapping(value = "/accueil", method = RequestMethod.GET) //--------------------------------------------------------- Accueil
    public String accueil(Model m, HttpSession session) {
        
        Personne p = new Personne();

        m.addAttribute("connexion", p);
        m.addAttribute("inscription", p);
        m.addAttribute("rolePersonne", RolePersonne.values());

        return "accueil";
    }

    @RequestMapping(value = "/inscription", method = RequestMethod.POST) //------------------------------------------------- Inscription
    public String inscriptionPost(@ModelAttribute("inscription") Personne p) {

        if (p.getMotDePasse().equals(p.getMotDePasse2())){
            personneCrudService.save(p);}
            
            return "redirect:/accueil";
    }

    @RequestMapping(value = "/historique", method = RequestMethod.GET) //---------------------------------------------------- Historique
    public String afficheHistorique(Model m, HttpSession session) {
        
        Personne p = new Personne();

        p = (Personne)session.getAttribute("connecte");
        List<Course> c = p.getCourses();
        List<Vehicule> v = p.getVehicules();
        
        m.addAttribute("personne", p);
        m.addAttribute("courses", c);
        m.addAttribute("vehicules", v);
        
        
        return "historique";
    }
    
    @RequestMapping(value = "/detailCourse/{idCourse}", method = RequestMethod.GET)//--------------------------------- Detail d'une course
    public String detailCourse (Model m, @PathVariable ("idCourse") long id){
        
        Course c = new Course();
        c = courseCrudService.findOne(id);
        
        m.addAttribute("course", c);
        
        return "detailCourse";
    }
}
