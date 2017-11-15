package com.bootcamp.entities;


import com.bootcamp.enums.EtatProgramme;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Link;

/**
 * @author soul
 */
@Entity
@ApiModel(value="Programme",
	description="representation d'une signature Programme")
public class Programme implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="Reference du Programme", required=true)
    private int reference;

    @ApiModelProperty(value="nom du programme", required=true)
    @NotNull(message = "Chaque programme doit avoir un nom")
    @Column(nullable = false)
    private String nom; //definissant le nom du projet

    @ApiModelProperty(value="Description du Programme", required=false)
    private String description; //description du programme

    @ApiModelProperty(value="reference objectif:Informations a recevoir en retour", required=true)
    private int idObjectif; //id recevoir permettant de faire des recherche sur un objectif precis

    @ApiModelProperty(value="Budget Previsionnel du Programme", required=true)
    private double budprevionnel;

    @ApiModelProperty(value="Cout reel du Programme", required=false)
    private double coutreel;

    @ApiModelProperty(value="Entrer une date de debut previsionnel du Programme", required=true)
    @NotNull(message = "Entrer une date de debut")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebutPrev;

    @ApiModelProperty(value="Entrer une date de fin previsionnel du Programme", required=true)
    @NotNull(message = "Entrer une date")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFinPrev;

    @ApiModelProperty(value="Date de debut Reelle du Programme", required=false)
    @NotNull(message = "Entrer une date de debut")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebutReel;

    @ApiModelProperty(value="Date de fin Reelle du Programme", required=false)
    @NotNull(message = "Entrer une date")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFinReel;

    @ApiModelProperty(value="Listes des differeentes phases du Programme", required=true)
    @OneToMany(cascade = CascadeType.PERSIST)
    @OrderBy("nom")
    private List<PhaseProgramme> nomPhases;

    @ApiModelProperty(value="Phase actuelle du Programme", required=true)
    
    @OneToOne
    private PhaseProgramme phaseActuelle;

    @ApiModelProperty(value="Etat actuel du Programme", required=true)
    @Enumerated(EnumType.STRING)
    private EtatProgramme etatProgramme;


  
    @Transient
    private Link self; // utilisant l'API JAX-RS 2

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdObjectif() {
        return idObjectif;
    }

    public void setIdObjectif(int idObjectif) {
        this.idObjectif = idObjectif;
    }

    public double getBudprevionnel() {
        return budprevionnel;
    }

    public void setBudprevionnel(double budprevionnel) {
        this.budprevionnel = budprevionnel;
    }

    public double getCoutreel() {
        return coutreel;
    }

    public void setCoutreel(double coutreel) {
        this.coutreel = coutreel;
    }

    public Date getDateDebutPrev() {
        return dateDebutPrev;
    }

    public void setDateDebutPrev(Date dateDebutPrev) {
        this.dateDebutPrev = dateDebutPrev;
    }

    public Date getDateFinPrev() {
        return dateFinPrev;
    }

    public void setDateFinPrev(Date dateFinPrev) {
        this.dateFinPrev = dateFinPrev;
    }

    public Date getDateDebutReel() {
        return dateDebutReel;
    }

    public void setDateDebutReel(Date dateDebutReel) {
        this.dateDebutReel = dateDebutReel;
    }

    public Date getDateFinReel() {
        return dateFinReel;
    }

    public void setDateFinReel(Date dateFinReel) {
        this.dateFinReel = dateFinReel;
    }

    public List<PhaseProgramme> getNomPhases() {
        return nomPhases;
    }

    public void setNomPhases(List<PhaseProgramme> nomPhases) {
        this.nomPhases = nomPhases;
    }

    public PhaseProgramme getPhaseActuelle() {
        return phaseActuelle;
    }

    public void setPhaseActuelle(PhaseProgramme phaseActuelle) {
        this.phaseActuelle = phaseActuelle;
    }

   


    public EtatProgramme getEtatProgramme() {
        return etatProgramme;
    }

    public void setEtatProgramme(EtatProgramme etatProgramme) {
        this.etatProgramme = etatProgramme;
    }
    
}
