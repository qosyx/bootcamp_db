/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Archange
 */
@Entity
@Table(name = "tp_beneficiaire")
@DiscriminatorValue("BENEFICIAIRE")
@ApiModel(value = "Beneficiaire Model", description = "Beneficiaire Model witch is a Personne Model")
public class Beneficiaire extends Personne {

    private int idcommune;

    public Beneficiaire(String nom) {
        super(nom);
    }

    public Beneficiaire(String nom, int idcommune) {
        super(nom);
        this.idcommune = idcommune;
    }

    public Beneficiaire() {
        super();
    }

    @ApiModelProperty(value = "Beneficiaire commune")
    public int getCommune() {
        return idcommune;
    }

    public void setCommune(int idcommune) {
        this.idcommune = idcommune;
    }

}
