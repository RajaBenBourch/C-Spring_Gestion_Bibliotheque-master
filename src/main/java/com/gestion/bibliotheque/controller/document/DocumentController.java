package com.gestion.bibliotheque.controller.document;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.bibliotheque.entity.Adherent;
import com.gestion.bibliotheque.entity.Dictionnaire;
import com.gestion.bibliotheque.entity.Documents;
import com.gestion.bibliotheque.entity.Livre;
import com.gestion.bibliotheque.entity.Revue;
import com.gestion.bibliotheque.service.DocumentService;


@Controller
@RequestMapping("/document")
public class DocumentController {
	@Autowired
	private DocumentService documentservice;
	
	@GetMapping("")
	public String indexDocument(Model model) {
		model.addAttribute("documents",this.documentservice.getAllDocument());
		return "/documentT/Document";
	}
	
	@GetMapping("delete")
	public String deleteAdherent(Model model , @RequestParam(name = "id") Long id) {
		documentservice.deleteDocument(id);
		return "redirect:/documentT";
	}
	
	@GetMapping("chercher")
	public String chercher(Model model,@RequestParam(name = "id") Long id) {
		List<Documents> document = new ArrayList<>();
		document.add(this.documentservice.getDocumentById(id));
		model.addAttribute("documents", document);	
		return "/documentT/Document";
		
	}
	
	@GetMapping("livre")
	public String livre(Model model) {
		model.addAttribute("documents",this.documentservice.getAllLivres());
		return "/documentT/Livre";
	}
	
	@GetMapping("revue")
	public String revue(Model model) {
		model.addAttribute("documents",this.documentservice.getAllRevue());
		return "/documentT/Revue";
	}
	
	@GetMapping("dictionnaire")
	public String dictionnaire(Model model) {
		model.addAttribute("documents",this.documentservice.getAllDictionnaire());
		return "/documentT/Dictionnaire";
	}
	
	
	
	@GetMapping("addlivre")
	public String addlivre(Model model) {
		model.addAttribute("livre",new Livre());
		return "/documentT/AjouterLivre";
	}
	
	@GetMapping("addrevue")
	public String addrevue(Model model) {
		model.addAttribute("revue",new Revue());
		return "/documentT/AjouterRevue";
	}
	
	@GetMapping("adddic")
	public String adddic(Model model) {
		model.addAttribute("dic",new Dictionnaire());
		return "/documentT/AjouterDictionnaire";
	}
	
	
	@GetMapping("editlivre")
	public String editlivre(Model model  ,@RequestParam(name = "id") Long id) {
		Documents  livre= this.documentservice.getDocumentById(id);
		model.addAttribute("livre",(Documents)livre);
		return "/documentT/ModifierLivre";
	}
	
	@GetMapping("editrevue")
	public String editrevue(Model model, @RequestParam(name = "id") Long id) {
		Documents  revue= this.documentservice.getDocumentById(id);
		model.addAttribute("revue",revue);
		return "/documentT/ModifierRevue";
	}
	
	@GetMapping("editdic")
	public String editdic(Model model ,  @RequestParam(name = "id") Long id) {
		Documents dic=  this.documentservice.getDocumentById(id);

		model.addAttribute("dic",dic);
		return "/documentT/ModifierDictionnaire";
	}
	
	@PostMapping("savelivre")
	public String savelivre(@Valid Livre livre
			,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "/documentT/Document";
		documentservice.save(livre);
		return "redirect:/documentT";
	}
	
	@PostMapping("saverevue")
	public String saverevue(@Valid Revue revue
			,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "/documentT/Document";
		documentservice.save(revue);
		return "redirect:/documentT";
	}
	
	@PostMapping("savedic")
	public String savedic(@Valid Dictionnaire dic
			,BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "/documentT/Document";
		documentservice.save(dic);
		return "redirect:/documentT";
	}


}
