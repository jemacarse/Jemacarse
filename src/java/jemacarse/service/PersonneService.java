package jemacarse.service;

import java.util.List;
import jemacarse.dao.PersonneDAO;
import jemacarse.entity.Personne;

public class PersonneService {

    public Personne rechercheParLoginEtMdp(String login, String motDePasse) {

        return new PersonneDAO().rechercheParLoginEtMdp(login, motDePasse);
    }

    public void inscription(Personne perso) {
        PersonneDAO dao = new PersonneDAO();

        List<Personne> listePersoAvecCeLogin = dao.rechercheParLogin(perso.getLogin());

        if (listePersoAvecCeLogin.size() > 0) {
            throw new RuntimeException("ce login existe deja");
        }
        dao.enregistrer(perso);

    }

    public void modifierProfil(Personne personne) {
        PersonneDAO dao = new PersonneDAO();
        new PersonneDAO().modifierProfil(personne);
    }

    public void supprimer(Long id) {
        new PersonneDAO().supprimer(id);
    }

}
