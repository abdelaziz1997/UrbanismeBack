package com.lismart.urbanisme.security.service;

import java.util.List;
import com.lismart.urbanisme.model.Demande;
import com.lismart.urbanisme.model.Demandeur;


public interface DemandeService {
	public Demande saveDemande(Demande demande) ;
	public void deleteDemande(long demandeId);
	public Demande findDemandeById(long demandeId);
	public boolean findDemandeByreference(String demandeRef);
	public List<Demande> retreiveDemandes();
	public Demande updateDemande(Demande demande);
	public Demande findDemandeByMaxId();
	public Demandeur saveDemandeur(Demandeur demandeur);
	public void deleteDemandeur(long demandeurId);
	public boolean findDemandeurById(long demandeurId);
	public Demandeur retreiveDemandeur(Long demandeurId);
}
