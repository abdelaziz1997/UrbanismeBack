package com.lismart.urbanisme.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lismart.urbanisme.message.request.CreationDossierForm;
import com.lismart.urbanisme.model.Demande;
import com.lismart.urbanisme.model.Demandeur;
import com.lismart.urbanisme.security.service.DemandeService;



@CrossOrigin(origins = "*")
@RestController
public class DemandeRestAPIs {
	@Autowired
	private DemandeService demandeService;
	
	@RequestMapping(value="/demandes")
	public List<Demande> listDemandes(){
		return demandeService.retreiveDemandes();
	}
	
	@RequestMapping(value="/saveDemande",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_DIRECTEUR') or hasRole('ROLE_CHEF_SRV')")
	public Demande saveDemande(@RequestBody Demande demande) {
		return demandeService.saveDemande(demande);	
	}
	@RequestMapping(value="/demande/maxId")
	@PreAuthorize("hasRole('ROLE_DIRECTEUR') or hasRole('ROLE_CHEF_SRV')")
	public long getDemandeWithMaxID(){
		long demandeId;
		if(demandeService.findDemandeByMaxId()!=null) {
			demandeId = demandeService.findDemandeByMaxId().getId();
		}else {
			demandeId = 0;
		}
		return demandeId;
	}
	
	@RequestMapping(value="/demandeur/saveDemandeur",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_DIRECTEUR') or hasRole('ROLE_CHEF_SRV')")
	public Demandeur saveDemandeur(@RequestBody CreationDossierForm f) {
		Demandeur demandeur = new Demandeur(f.getNomDemandeur_ar(), f.getNomDemandeur_fr(), f.getPreDemandeur_ar(), f.getPreDemandeur_fr(), f.getQualite_ar(), f.getQualite_fr());
		Demande demande = new Demande(f.getReference(),f.getDate_depot(), f.getStatus(), f.getPlan());
		demande.setDemandeur(demandeur);
		demandeur.getDemandes().add(demande);
		return demandeService.saveDemandeur(demandeur);
	}

   
}
