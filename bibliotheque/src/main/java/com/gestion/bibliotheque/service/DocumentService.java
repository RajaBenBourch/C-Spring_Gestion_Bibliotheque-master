package com.gestion.bibliotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.bibliotheque.entity.Dictionnaire;
import com.gestion.bibliotheque.entity.Documents;
import com.gestion.bibliotheque.entity.Livre;
import com.gestion.bibliotheque.entity.Revue;
import com.gestion.bibliotheque.repository.DictionnaireRepository;
import com.gestion.bibliotheque.repository.DocumentRepository;
import com.gestion.bibliotheque.repository.LivreRepository;
import com.gestion.bibliotheque.repository.RevueRepository;


@Service
@Transactional
public class DocumentService {
	@Autowired
	private DocumentRepository documentrepository;
	
	@Autowired
	private LivreRepository livrerepository;
	
	@Autowired
	private RevueRepository revuerepository;
	
	@Autowired
	private DictionnaireRepository dictionnairerepository;
	
	public Documents save(Documents document) {
		return this.documentrepository.save(document);
	}
	
	public Documents getDocumentById(Long id) {
		return this.documentrepository.findById(id).get();
	}
	
	public boolean deleteDocument(Long id) {
		this.documentrepository.deleteById(id);
		return true;
	}
	
	

	
	public List<Documents> getAllDocument(){
		return this.documentrepository.findAll();
		}
	
	public List<Livre> getAllLivres(){
		return this.livrerepository.findAll();
		}
	
	public List<Revue> getAllRevue(){
		return this.revuerepository.findAll();
		}
	
	public List<Dictionnaire> getAllDictionnaire(){
		return this.dictionnairerepository.findAll();
	}
	
}
