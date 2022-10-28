package com.gestion.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.bibliotheque.entity.Adherent;
import com.gestion.bibliotheque.repository.AdherentRepository;



@Service
@Transactional
public class AdherentService {
	
	@Autowired(required=true)
	private AdherentRepository adherentrepository;
	
	
	public Adherent findAdherentByCin(String cin) {
		return  this.adherentrepository.findByCin(cin);
	}
	
	public Adherent findAdherentById(Long id) {
		return this.adherentrepository.findById(id).get();
	}
	
	public Adherent save(Adherent adherent) {		
		return this.adherentrepository.save(adherent);
	}
	
	public List<Adherent> getAllAdherent(){
		return adherentrepository.findAll();
		}
	
	
	
	public boolean  deleteAdherent(Long l) {
		this.adherentrepository.deleteById(l);
		return true;
	}
	
}