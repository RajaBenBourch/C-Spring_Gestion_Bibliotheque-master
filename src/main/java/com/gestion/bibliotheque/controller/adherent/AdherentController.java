package com.gestion.bibliotheque.controller.adherent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.bibliotheque.entity.Adherent;
import com.gestion.bibliotheque.entity.Emprunt;
import com.gestion.bibliotheque.service.AdherentService;
import com.gestion.bibliotheque.service.EmpruntService;

@Controller
@RequestMapping("/adherent")
public class AdherentController {
	@Autowired
	private AdherentService adherntservice;
	
	@Autowired
	private EmpruntService empruntservice;
	
	@GetMapping("")
	public String indexAdherent(Model model) {
		model.addAttribute("adherents", this.adherntservice.getAllAdherent());	
		return "/adherentT/Adherent";
	}
	
	@GetMapping("delete")
	public String deleteAdherent(Model model , @RequestParam(name = "id") Long id) {
		adherntservice.deleteAdherent(id);
		return "redirect:/adherentT";
	}
	
	@GetMapping("chercher")
	public String chercher(Model model,@RequestParam(name = "cin") String cin) {
		List<Adherent> adherent = new ArrayList<>();
		adherent.add(this.adherntservice.findAdherentByCin(cin));
		model.addAttribute("adherents", adherent);	
		return "/adherentT/Adherent";
		
	}
	
	@GetMapping("edit")
	public String modifier(Model model,@RequestParam(name = "id") Long id) {
		Adherent adherent=this.adherntservice.findAdherentById(id);
		model.addAttribute("adherent",adherent);
		return "/adherentT/ModifierAdherent";
		
	}
	
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute(new Adherent());
		return "/adherentT/AjouterAdherent";
	}
	
	@PostMapping("save")
	public String save(
			@RequestParam(name = "dateNaissance", defaultValue = "1900-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d1
			,@Valid Adherent adherent
			,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "/adherenT/AjouterAdherent";
		adherntservice.save(adherent);
		return "redirect:/adherentT";
	}
	
	@GetMapping("profil")
	public String consulterAdherent(Model model ,@RequestParam(name = "id") Long id) {
		Adherent a =adherntservice.findAdherentById(id);
		List<Emprunt> emprunts = empruntservice.getALlEmpruntAdherent(a);
		model.addAttribute("emprunts", emprunts);
		model.addAttribute("adherent", a);		
		return "/adherentT/ProfileAdherent";
	}
}
