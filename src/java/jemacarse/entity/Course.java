package jemacarse.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Course implements Serializable {
    
    public enum Etat{
        
        PAYE, IMPAYE
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String commentaireChauffeur, commentaireClient;
    private double id_client, id_chauffeur, montant, distance, note_chauffeur, note_client, latPosDepart_client, lgPosDepart_client, latPosDepart_chauffeur, lgPosDepart_chauffeur, latPosArrivee, lgPosArrivee;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCourse;
    
    @Enumerated(EnumType.STRING)
    private Etat etat;
    
    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;
    
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    public double getLatPosDepart_client() {
        return latPosDepart_client;
    }

    public void setLatPosDepart_client(double latPosDepart_client) {
        this.latPosDepart_client = latPosDepart_client;
    }

    public double getLgPosDepart_client() {
        return lgPosDepart_client;
    }

    public void setLgPosDepart_client(double lgPosDepart_client) {
        this.lgPosDepart_client = lgPosDepart_client;
    }

    public double getLatPosDepart_chauffeur() {
        return latPosDepart_chauffeur;
    }

    public void setLatPosDepart_chauffeur(double latPosDepart_chauffeur) {
        this.latPosDepart_chauffeur = latPosDepart_chauffeur;
    }

    public double getLgPosDepart_chauffeur() {
        return lgPosDepart_chauffeur;
    }

    public void setLgPosDepart_chauffeur(double lgPosDepart_chauffeur) {
        this.lgPosDepart_chauffeur = lgPosDepart_chauffeur;
    }

    public double getLatPosArrivee() {
        return latPosArrivee;
    }

    public void setLatPosArrivee(double latPosArrivee) {
        this.latPosArrivee = latPosArrivee;
    }

    public double getLgPosArrivee() {
        return lgPosArrivee;
    }

    public void setLgPosArrivee(double lgPosArrivee) {
        this.lgPosArrivee = lgPosArrivee;
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

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public double getId_client() {
        return id_client;
    }

    public void setId_client(double id_client) {
        this.id_client = id_client;
    }

    public double getId_chauffeur() {
        return id_chauffeur;
    }

    public void setId_chauffeur(double id_chauffeur) {
        this.id_chauffeur = id_chauffeur;
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

    public double getNote_chauffeur() {
        return note_chauffeur;
    }

    public void setNote_chauffeur(double note_chauffeur) {
        this.note_chauffeur = note_chauffeur;
    }

    public double getNote_client() {
        return note_client;
    }

    public void setNote_client(double note_client) {
        this.note_client = note_client;
    }

    public Date getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(Date dateCourse) {
        this.dateCourse = dateCourse;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jemacarse.entity.Course[ id=" + id + " ]";
    }
    
}
