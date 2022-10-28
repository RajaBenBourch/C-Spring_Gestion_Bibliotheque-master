package com.gestion.bibliotheque.entity;

import java.util.Collection;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typedoc",discriminatorType = DiscriminatorType.STRING,length = 13)
@Table(name = "Doc")

public class Documents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank

	public Long id;
	@Column(name="nom")
	private String nom;
	
	@Column(name="PrixVente")
	private double prixDeVente;
	
	@OneToMany(mappedBy = "document",cascade=CascadeType.ALL)
	private Collection<Emprunt> emprunts;
	
	

	public double getPrixDeVente() {
		return prixDeVente;
	}
	public void setPrixDeVente(double prixDeVente) {
		this.prixDeVente = prixDeVente;
	}
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", nom=" + nom + ", prixDeVente=" + prixDeVente + "]";
	}
	
	public Documents(String nom, double prixDeVente) {
		super();
		this.nom = nom;
		this.prixDeVente = prixDeVente;
	}
	public Documents() {
		super();
	}
	
}
