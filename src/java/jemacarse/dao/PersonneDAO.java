package jemacarse.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jemacarse.entity.Personne;

public class PersonneDAO {

    public Personne rechercheParLoginEtMdp(String login, String motDePasse) {

        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();

        Query query = em.createQuery("select p from Personne p where p.login=:login AND p.motDePasse=:motDePasse");
        query.setParameter("login", login);
        query.setParameter("motDePasse", motDePasse);

        return (Personne) query.getSingleResult();
    }

    public void enregistrer(Personne p) {
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public List<Personne> rechercheParLogin(String login) {
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        return em.createQuery("SELECT p from Personne p WHERE p.login=:login").setParameter("login", login).getResultList();

    }

    public void modifierProfil(Personne personne) {
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        em.merge(personne);
        em.getTransaction().commit();
    }

    public void supprimer(long id) {
        EntityManager em = Persistence.createEntityManagerFactory("JemacarsePU").createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("delete from Personne WHERE id=:idperso");
        q.setParameter("idperso", id);
        em.getTransaction().commit();
    }

}