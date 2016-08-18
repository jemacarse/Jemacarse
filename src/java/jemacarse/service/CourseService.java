package jemacarse.service;

import java.util.List;
import jemacarse.dao.CourseDAO;
import jemacarse.entity.Course;

public class CourseService {

    public void inscription(Course c) {
        
        CourseDAO dao = new CourseDAO();
        new CourseDAO().enregistrer(c);
    }

    public List<Course> lister() {
        
        CourseDAO dao = new CourseDAO();
        return dao.listerTous();
    }

    public Course rechercherParId(long id) {
        
        CourseDAO dao = new CourseDAO();
        return dao.rechercherParId(id);
    }

    public void modifierCourse(Course c) {
        
        CourseDAO dao = new CourseDAO();
        new CourseDAO().modifierNote(c);
    }
}
