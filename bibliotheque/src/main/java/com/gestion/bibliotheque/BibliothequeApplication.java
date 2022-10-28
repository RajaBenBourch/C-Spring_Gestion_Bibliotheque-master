package com.gestion.bibliotheque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.error.ErrorController;

import com.gestion.bibliotheque.entity.Adherent;
import com.gestion.bibliotheque.entity.Dictionnaire;
import com.gestion.bibliotheque.entity.Emprunt;
import com.gestion.bibliotheque.entity.Livre;
import com.gestion.bibliotheque.entity.Revue;
import com.gestion.bibliotheque.service.AdherentService;
import com.gestion.bibliotheque.service.DocumentService;
import com.gestion.bibliotheque.service.EmpruntService;





@SpringBootApplication
@EntityScan
public class BibliothequeApplication  implements CommandLineRunner , ErrorController{
	
	@Autowired
	private AdherentService adherentService;
	
	@Autowired
	private DocumentService documentService;
	
	
	@Autowired
	private EmpruntService empruntService;

	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Adherent adherent1=new Adherent("Aloumairi","Rajaa","Casa Blanca","G7687",new Date());
		Adherent adherent2=new Adherent("Ayouni","Me","Kenitra","G737470",new Date());
		Adherent adherent3=new Adherent("test","tse1","Fes","CD7823",new Date());
		
	
		
		Livre livre=new Livre();
		Dictionnaire dictionnaire=new Dictionnaire();
		Revue revue = new Revue();
		
		livre.setAuteur("Ahmed");
		livre.setNbpage(300);
		livre.setPrixDeVente(190.00);
	
		dictionnaire.setLangue("Arabic");
		dictionnaire.setPrixDeVente(120.00);
		dictionnaire.setId(2L);
		
		revue.setAnnee(2014);
		revue.setPrixDeVente(60.00);
		
		Emprunt emprunt = new Emprunt();
		emprunt.setAdherent(adherent1);
		emprunt.setDocument(dictionnaire);
		emprunt.setDate_emprunt(new Date());
		emprunt.setDate_retour(new Date());
		
	/*	adherentService.save(adherent1);
		adherentService.save(adherent2);
		adherentService.save(adherent3);
		
		documentService.save(revue);
		documentService.save(dictionnaire);
		documentService.save(livre);
			

		empruntService.save(emprunt);
		*/
		
		//System.out.println(adherentService.getAllAdherent());
		//System.out.println(documentService.getAllDocument(0, 4).getContent());
		//System.out.println(empruntService.getAllEmprunt(0, 4).getContent());
		
		//System.out.println(adherentService.deleteAdherent(5L));

		//System.out.println(adherentService.findAdherentByCin("G737470"));
		//System.out.println(documentService.getDocumentById(1L).getNom());

		//System.out.println(this.documentService.getDocumentById(1L).getId());
		
		
		


		
	}

}
