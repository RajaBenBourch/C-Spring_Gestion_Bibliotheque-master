package com.gestion.bibliotheque.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Revue")

public class Revue extends Documents{	
	@Column(name="annee")
	private int  annee;

	public Revue(String nom, double prixDeVente, int annee) {
		super(nom, prixDeVente);
		this.annee = annee;
	}

	public Revue() {
		super();
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	public String toString() {
		return "Revue [annee=" + annee + "]";
	}
	
	

	
	

	
}