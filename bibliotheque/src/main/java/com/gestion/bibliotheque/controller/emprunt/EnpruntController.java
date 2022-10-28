package com.gestion.bibliotheque.controller.emprunt;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.bibliotheque.entity.Adherent;
import com.gestion.bibliotheque.entity.Documents;
import com.gestion.bibliotheque.entity.Emprunt;
import com.gestion.bibliotheque.service.AdherentService;
import com.gestion.bibliotheque.service.DocumentService;
import com.gestion.bibliotheque.service.EmpruntService;

@Controller
@RequestMapping("/emprunt")
public class EnpruntController {
	@Autowired
	private EmpruntService empruntservice;
	
	@Autowired
	private AdherentService  adherentservice;
	
	@Autowired
	private DocumentService documentservice;
	
	@GetMapping("")
	public String indexEmprunts(Model model) {
		model.addAttribute("emprunts",this.empruntservice.getAllEmprunt());
		return "empruntT/Emprunt.html";
	}
	
	@GetMapping("delete")
	public String deleteAdherent(Model model , @RequestParam(name = "id") Long id) {
		empruntservice.delete(id);
		return "redirect:";
	}
	

	@GetMapping("edit")
	public String edit(Model model  ,@RequestParam(name = "id") Long id) {
		Emprunt  emprunt= this.empruntservice.findone(id);
		model.addAttribute("emprunt",emprunt);
		return "empruntT/ModifierEmprunt";
	}
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute(new Emprunt());
		return "empruntT/AjouterEmprunt";
	}
	
	@PostMapping("save")
	public String save(
			@RequestParam(name = "date_retour", defaultValue = "1900-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1
			,@Valid Emprunt emprunt
			,@RequestParam(name = "adherent") Long id_adherent
			,@RequestParam(name = "document") Long id_document
			,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "empruntT/AjouterEmprunt";
		Adherent adherent=this.adherentservice.findAdherentById(id_adherent);
		Documents document=this.documentservice.getDocumentById(id_document);
		if(adherent==null)
			throw new RuntimeException("Adhernt Introuvable check your Id");
		if(document==null)
			throw new RuntimeException("Document Introuvable check your Id");
		emprunt.setAdherent(adherent);
		emprunt.setDocument(document);
		emprunt.setDate_emprunt(new Date());
		this.empruntservice.save(emprunt);
		return "redirect:";
	}
	
	
	
}
