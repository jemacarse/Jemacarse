package jemacarse.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import jemacarse.entity.Course;

public class CourseDAO {

    public void enregistrer(Course c) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    public List<Course> listerTous() {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        return em.createQuery("SELECT * FROM Course").getResultList();
    }

    public Course rechercherParId(long id) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        return em.find(Course.class, id);
    }

    public void modifierNote(Course c) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }
}
