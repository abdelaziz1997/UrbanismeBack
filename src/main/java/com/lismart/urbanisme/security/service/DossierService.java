package com.lismart.urbanisme.security.service;

import java.util.List;

import com.lismart.urbanisme.model.Dossier;


public interface DossierService {
	
	public Dossier saveDossier(Dossier dossier);
	public void deleteDossier(long dossierId);
	public Dossier findDossierById(long dossierId);
	public List<Dossier> retreiveDossiers();
	public Dossier updateDossier(Dossier dossier);
	
}
