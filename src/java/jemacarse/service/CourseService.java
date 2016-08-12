package jemacarse.service;

import java.util.List;
import jemacarse.dao.CourseDAO;
import jemacarse.entity.Course;

public class CourseService {

    public void inscription(Course cou) {
        CourseDAO dao = new CourseDAO();
        new CourseDAO().enregistrer(cou);
    }

    public List<Course> lister() {
        CourseDAO dao = new CourseDAO();
        return dao.listerTous();
    }

    public Course rechercherParId(long id) {
        CourseDAO dao = new CourseDAO();
        return dao.rechercherParId(id);

    }

    public void modifierCourse(Course course) {
        CourseDAO dao = new CourseDAO();
        new CourseDAO().modifierNote(course);
    }

}
