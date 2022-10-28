package com.gestion.bibliotheque.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gestion.bibliotheque.entity.Adherent;
import com.gestion.bibliotheque.entity.Emprunt;
import com.gestion.bibliotheque.repository.EmpruntRepository;




@Service("EmpruntService")
public class EmpruntService {
	
	@Autowired
	private EmpruntRepository empruntrepository;

	
	public Emprunt findone(Long ID) {
		
		return empruntrepository.findById(ID).get();
	}

	
	public Emprunt save(Emprunt emprunt) {
		
		return empruntrepository.save(emprunt);
	}

	
	public boolean delete(Long ID) {
		empruntrepository.deleteById(ID);
		return true;
	} 
	
	
	public List<Emprunt> getAllEmprunt(){
		return empruntrepository.findAll();
	}
	
	
	public List<Emprunt> getALlEmpruntAdherent(Adherent adherent){
		return empruntrepository.findByAdherent(adherent);
	}

}
