package jemacarse.service;

import java.util.List;
import jemacarse.dao.CourseDAO;
import jemacarse.dao.VehiculeDAO;
import jemacarse.entity.Course;
import jemacarse.entity.Vehicule;

public class VehiculeService {

    public void inscription(Vehicule v) {
        VehiculeDAO dao = new VehiculeDAO();
        new VehiculeDAO().enregistrer(v);
    }

    public List<Course> lister() {
        CourseDAO dao = new CourseDAO();
        return dao.listerTous();
    }

    public Vehicule rechercherParId(long id) {
        VehiculeDAO dao = new VehiculeDAO();
        return dao.rechercherParId(id);
    }

    public void modifierVehicule(Vehicule v) {
        VehiculeDAO dao = new VehiculeDAO();
        new VehiculeDAO().modifierVehicule(v);
    }

    public void supprimer(Vehicule v) {
        new VehiculeDAO().supprimer(v);
    }
}
