package com.gestion.bibliotheque.controller;

import java.util.ArrayList;




import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
@RequestMapping("/")
public class AcceuilControlller {
	
	@GetMapping(value="")
	public String acceuil() {
		return "Home";
	}
	
	/*
	@Autowired
	private AdherentService adherentService;
	@Autowired
	private LivreService livreService;
	@Autowired
	private EmpruntService empruntService;
	@Autowired
	private RevueService revueService;
	@Autowired
	private DictionnaireService dictionnaireService;
	
	@Autowired
	private AdherentRepository adherentrepository;


    @Value("${home.message}")

    @GetMapping("/")
    public String main() {

        return "Home";
    }
    

    // /hello?name=kotlin
    @GetMapping("/home")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        model.addAttribute("message", name);

        return "Home"; 
    }
    
    @GetMapping("/AjouterAdherent")
    public String ajouteradherent( Model model) {   	
    	model.addAttribute("adherent", new Adherent());
    	return "AjouterAdherent"; 
    }
    
 
    
    @PostMapping("/AjouterAdherent")
    public String save(@ModelAttribute Adherent newAdherent, Model model) {   
    			adherentService.save(newAdherent);
        return "Adherent";
    }
 

    @GetMapping("/ModifierAdherent")
    public String modifieradherent(@ModelAttribute Adherent adherent, Model model) {
    	Adherent savedAdherent = adherentService.save(adherent);
    	model.addAttribute("adherent", savedAdherent);
        return "ModifierAdherent"; 
    }
    
    
    @GetMapping("/Delete")
    public String delete() {

       
        return "DeleteAdherent"; 
    }
    
    
    @GetMapping("/AjouterDocument")
    public String ajouterdocument() {

       
        return "AjouterDocument"; 
    }
    @GetMapping("/ModifierDocument")
    public String modifierdocument() {

       
        return "ModifierDocument"; 
    }
 
    
    @GetMapping("/adherent")
    public String mainParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        
    	model.addAttribute("message", name);
        return "Adherent"; 
    }
    
    @GetMapping("/document")
    public String mainoumaParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        model.addAttribute("message", name);

        return "Document"; 
    }
    @GetMapping("/emprunt")
    public String mainooParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {

        model.addAttribute("message", name);

        return "Emprunt"; 
    }
    
    @GetMapping("/ProfilAdherent")
    public String profiladherent() {
    	
    	
    	return "ProfilAdherent"; 
    }
    @GetMapping("/ModifierProfil")
    public String modifierprofil() {

       
        return "ModifierProfil"; 
    }*/
    }
