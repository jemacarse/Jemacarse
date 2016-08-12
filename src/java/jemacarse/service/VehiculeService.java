package jemacarse.service;

import java.util.List;
import jemacarse.dao.CourseDAO;
import jemacarse.dao.VehiculeDAO;
import jemacarse.entity.Course;
import jemacarse.entity.Vehicule;

public class VehiculeService {

    public void inscription(Vehicule veh) {
        VehiculeDAO dao = new VehiculeDAO();
        new VehiculeDAO().enregistrer(veh);
    }

    public List<Course> lister() {
        CourseDAO dao = new CourseDAO();
        return dao.listerTous();
    }

    public Vehicule rechercherParId(long id) {
        VehiculeDAO dao = new VehiculeDAO();
        return dao.rechercherParId(id);

    }

    public void modifierVehicule(Vehicule vehicule) {
        VehiculeDAO dao = new VehiculeDAO();
        new VehiculeDAO().modifierVehicule(vehicule);
    }

    public void supprimer(Long id) {
        new VehiculeDAO().supprimer(id);
    }

}
