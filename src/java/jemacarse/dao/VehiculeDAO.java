package jemacarse.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jemacarse.entity.Vehicule;

public class VehiculeDAO {

    public void enregistrer(Vehicule v) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        
        em.persist(v);
        
        em.getTransaction().commit();
    }

    public List<Vehicule> listerTous() {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        return em.createQuery("SELECT * FROM Vehicule v").getResultList();
    }

    public Vehicule rechercherParId(long id) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        return em.find(Vehicule.class, id);
    }

    public void modifierVehicule(Vehicule v) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        
        em.merge(v);
        
        em.getTransaction().commit();
    }

    public void supprimer(Vehicule v) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        
        em.remove(v);
        
        em.getTransaction().commit();
    }
}
