package com.lismart.urbanisme.security.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lismart.urbanisme.model.Dossier;
import com.lismart.urbanisme.repository.DossierRepository;

@Service
@Transactional
public class DossierServiceImpl implements DossierService {
	
	@Autowired
	private DossierRepository dossierRepository;
	
	@Override
	public Dossier saveDossier(Dossier dossier) {
		this.dossierRepository.save(dossier);
		return null;
	}

	@Override
	public void deleteDossier(long dossierId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dossier findDossierById(long dossierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dossier> retreiveDossiers() {
		return dossierRepository.findAll();
	}

	@Override
	public Dossier updateDossier(Dossier dossier) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
