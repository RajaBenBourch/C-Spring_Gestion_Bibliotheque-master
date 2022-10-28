package com.gestion.bibliotheque.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Adherent")
public class Adherent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="adress")
	private String adress;
	@Column(name="cin")
	private String cin;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date")
	private Date date;
	
	@OneToMany(mappedBy = "adherent",cascade=CascadeType.ALL)
	private Collection<Emprunt> emprunts;
	
	
	public Adherent( String nom, String prenom, String adresse, String cin, Date date) {
		super();
	
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adresse;
		this.cin = cin;
		this.date = date;
	}


	public Adherent() {
		super();
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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Adherent [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adress=" + adress + ", cin=" + cin
				+ " date=" + date + "]";
	}
	
	
	
}
