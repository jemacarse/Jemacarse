package jemacarse.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Course implements Serializable {

    public enum EtatCourse {

        PAYE, IMPAYE
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCourse;

    private String commentaireChauffeur, commentaireClient, adresseDepartClient, adresseDepartChauffeur, adresseArrivee;
    private double montant, distance, noteChauffeur, noteClient;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCourse;

    @Enumerated(EnumType.STRING)
    private EtatCourse etatCourse;

    @ManyToMany
    @JoinColumn(name = "personne_course")
    private List <Personne> personnes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    public String getAdresseDepartClient() {
        return adresseDepartClient;
    }

    public void setAdresseDepartClient(String adresseDepartClient) {
        this.adresseDepartClient = adresseDepartClient;
    }

    public String getAdresseDepartChauffeur() {
        return adresseDepartChauffeur;
    }

    public void setAdresseDepartChauffeur(String adresseDepartChauffeur) {
        this.adresseDepartChauffeur = adresseDepartChauffeur;
    }

    public String getAdresseArrivee() {
        return adresseArrivee;
    }

    public void setAdresseArrivee(String adresseArrivee) {
        this.adresseArrivee = adresseArrivee;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }
    
    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getCommentaireChauffeur() {
        return commentaireChauffeur;
    }

    public void setCommentaireChauffeur(String commentaireChauffeur) {
        this.commentaireChauffeur = commentaireChauffeur;
    }

    public String getCommentaireClient() {
        return commentaireClient;
    }

    public void setCommentaireClient(String commentaireClient) {
        this.commentaireClient = commentaireClient;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getNoteChauffeur() {
        return noteChauffeur;
    }

    public void setNoteChauffeur(double noteChauffeur) {
        this.noteChauffeur = noteChauffeur;
    }

    public double getNoteClient() {
        return noteClient;
    }

    public void setNoteClient(double noteClient) {
        this.noteClient = noteClient;
    }

    public Date getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(Date dateCourse) {
        this.dateCourse = dateCourse;
    }

    public EtatCourse getEtatCourse() {
        return etatCourse;
    }

    public void setEtatCourse(EtatCourse etatCourse) {
        this.etatCourse = etatCourse;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idCourse);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.idCourse, other.idCourse)) {
            return false;
        }
        return true;
    }

    

    
}
