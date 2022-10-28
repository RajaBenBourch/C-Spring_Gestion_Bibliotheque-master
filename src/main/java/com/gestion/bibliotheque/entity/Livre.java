package com.gestion.bibliotheque.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;





@Entity
@DiscriminatorValue("Livre")

public class Livre extends Documents {

	@Column(name="auteur")
	private String auteur;
	@Column(name="nbpage")
	private int nbpage;
			
	public Livre(String nom, double prixDeVente, String auteur, int nbpage) {
		super(nom, prixDeVente);
		this.auteur = auteur;
		this.nbpage = nbpage;
	}

	public Livre() {
		super();
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getNbpage() {
		return nbpage;
	}

	public void setNbpage(int nbpage) {
		this.nbpage = nbpage;
	}

	@Override
	public String toString() {
		return "Livre [auteur=" + auteur + ", nbpage=" + nbpage + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

	

}

