package jemacarse.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jemacarse.entity.Personne;

public class PersonneDAO {

    public Personne rechercheParLoginEtMdp(String login, String motDePasse) {

        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();

        return (Personne) em.createQuery("select p from Personne p where p.login=:login AND p.motDePasse=:motDePasse")
        .setParameter("login", login)
        .setParameter("motDePasse", motDePasse).getSingleResult();
    }

    public void ajouterPersonne(Personne p) throws RuntimeException {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        
        em.persist(p);

        em.getTransaction().commit();
    }

    public List<Personne> rechercheParLogin(String login) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        return em.createQuery("SELECT p from Personne p WHERE p.login=:login").setParameter("login", login).getResultList();
    }

    public void modifierProfil(Personne p) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        
        em.merge(p);
        
        em.getTransaction().commit();
    }

    public void supprimer(Personne p) {
        
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        
        em.remove(p);
        
        em.getTransaction().commit();
    }
}