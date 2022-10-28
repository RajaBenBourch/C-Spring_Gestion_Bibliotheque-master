package com.gestion.bibliotheque.entity;




import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Emprunt")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id_emprunt;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_emprunt")
	private Date date_emprunt;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_retour")
	private Date date_retour;

    
    @JoinColumn()
	@ManyToOne(fetch = FetchType.EAGER)
	private Adherent adherent;
	
	
    
    @JoinColumn()
    @ManyToOne(fetch = FetchType.EAGER)
    private Documents document;


	public Emprunt(Date date_emprunt, Date date_retour, Adherent adherent, Documents document) {
		super();
		this.date_emprunt = date_emprunt;
		this.date_retour = date_retour;
		this.adherent = adherent;
		this.document = document;
	}


	public Emprunt() {
		super();
	}


	public Long getId_emprunt() {
		return id_emprunt;
	}


	public void setId_emprunt(Long id_emprunt) {
		this.id_emprunt = id_emprunt;
	}


	public Date getDate_emprunt() {
		return date_emprunt;
	}


	public void setDate_emprunt(Date date_emprunt) {
		this.date_emprunt = date_emprunt;
	}


	public Date getDate_retour() {
		return date_retour;
	}


	public void setDate_retour(Date date_retour) {
		this.date_retour = date_retour;
	}


	public Adherent getAdherent() {
		return adherent;
	}


	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}


	public Documents getDocument() {
		return document;
	}


	public void setDocument(Documents document) {
		this.document = document;
	}


	@Override
	public String toString() {
		return "Emprunt [id_emprunt=" + id_emprunt + ", date_emprunt=" + date_emprunt + ", date_retour=" + date_retour
				+ ", adherent=" + adherent + ", document=" + document + "]";
	}
    
    
	
	
}
