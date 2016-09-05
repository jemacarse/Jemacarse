package jemacarse.service;

import java.util.List;
import jemacarse.entity.Personne;
import jemacarse.entity.Vehicule;
import org.springframework.data.repository.CrudRepository;

public interface PersonneCrudService extends CrudRepository<Personne, Long>{
    
    public Personne findOneByLoginAndMotDePasse (String login, String mdp);
    
    public List <Personne> findAllByVehiculeDisponibilite (Vehicule.Disponibilite dispo);
    
    
}
