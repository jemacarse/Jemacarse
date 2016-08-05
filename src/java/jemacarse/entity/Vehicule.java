package jemacarse.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Vehicule implements Serializable {
    
    public enum TypeVehicule{
        
        BERLINE, COUPE, CAMIONNETTE
    }
    
    public enum Disponibilite {
        
        LIBRE, OCCUPE
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String marque, modele, immatriculation;
    private double prixParKm, nbPlaces;
    
    @Enumerated(EnumType.STRING)
    private TypeVehicule typeVehicule;
    
    @Enumerated(EnumType.STRING)
    private Disponibilite disponibilite;
    
    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;
    
    @OneToMany(mappedBy = "vehicule")
    private List<Course> courses = new ArrayList<>();

    public Disponibilite getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Disponibilite disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(double nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public double getPrixParKm() {
        return prixParKm;
    }

    public void setPrixParKm(double prixParKm) {
        this.prixParKm = prixParKm;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicule)) {
            return false;
        }
        Vehicule other = (Vehicule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jemacarse.entity.Vehicule[ id=" + id + " ]";
    }
    
}
