package jemacarse.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import jemacarse.entity.Course;
import jemacarse.entity.Personne;
import jemacarse.service.CourseCrudService;
import jemacarse.service.PersonneCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CourseController {
    
    @Autowired
    private CourseCrudService courseCrudService;
    
    @Autowired
    private PersonneCrudService personneCrudService;
    
    @RequestMapping(value = "/detail_course/{idCourse}", method = RequestMethod.GET)//--------------------------------- Detail d'une course
    public String detailCourse (Model m, @PathVariable long idCourse){
        
        Course c = new Course();
        c = courseCrudService.findOne(idCourse);
        List <Personne> persCourse = c.getPersonnes();
        
        for (Personne p : persCourse){
            
            p = personneCrudService.findOne(p.getIdPersonne());
            
            if(p.getRolePersonne().equals(Personne.RolePersonne.CHAUFFEUR)){
               m.addAttribute("chauffeur", p);}
            
            if(p.getRolePersonne().equals(Personne.RolePersonne.CLIENT)){
               m.addAttribute("client", p);}
        }
        
        m.addAttribute("course", c);
        
        return "detail_course";
    }
    
    @RequestMapping(value = "/itineraire", method = RequestMethod.GET)
    public String definirItineraireGET (Model m, HttpSession session){
        
        Course c = new Course();
        m.addAttribute("course", c);
        
        return "itineraire";
    }
    
    @RequestMapping(value = "/itineraire", method = RequestMethod.POST)
    @ResponseBody
    public String enregistremantCourse (@ModelAttribute Course c, HttpSession session){
        
        List <Personne> p = new ArrayList<>();
        p.add((Personne)session.getAttribute("connecte"));
        
        c.setPersonnes(p);
        courseCrudService.save(c);
        
        return "itineraire";
    }
}
