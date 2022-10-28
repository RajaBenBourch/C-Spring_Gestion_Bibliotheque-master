package com.gestion.bibliotheque.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue("Dictionnaire")

public class Dictionnaire extends Documents {
	
	
	@Column(name="langue")
	private String langue;
	
	

	public Dictionnaire(String nom, double prixDeVente, String langue) {
		super(nom, prixDeVente);
		this.langue = langue;
	}

	@Override
	public String toString() {
		return "Dictionnaire [langue=" + langue + "]";
	}
	
	

	public Dictionnaire() {
		super();
	}
	
	
	

	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
	

	
	

}