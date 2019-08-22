package com.lismart.urbanisme.security.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lismart.urbanisme.model.Demande;
import com.lismart.urbanisme.model.Demandeur;
import com.lismart.urbanisme.repository.DemandeRepository;
import com.lismart.urbanisme.repository.DemandeurRepository;


@Service
@Transactional
public class DemandeServiceImpl implements DemandeService {
	
	@Autowired
	private DemandeRepository demandeRepository;
	
	@Autowired
	private DemandeurRepository demandeurRepository;

	@Override
	public Demande saveDemande(Demande demande) {
		return demandeRepository.save(demande);
	}

	@Override
	public void deleteDemande(long demandeId) {
		demandeRepository.deleteById(demandeId);
	}

	@Override
	public Demande findDemandeById(long demandeId) {
		Demande demande = demandeRepository.findById(demandeId).orElse(null);
		return demande;
	}
	
	@Override
	public Demande findDemandeByMaxId() {
		return demandeRepository.MaxID();
	}

	@Override
	public boolean findDemandeByreference(String demandeRef) {
		if(demandeRepository.findByreference (demandeRef) != null)
			return true;
		return false;
	}

	@Override
	public List<Demande> retreiveDemandes() {
		return demandeRepository.findAll();
	}

	@Override
	public Demande updateDemande(Demande demande) {
		return demandeRepository.save(demande);
	}

	@Override
	public Demandeur saveDemandeur(Demandeur demandeur) {
		return demandeurRepository.save(demandeur);
	}

	@Override
	public void deleteDemandeur(long demandeurId) {
		demandeurRepository.deleteById(demandeurId);
	}

	@Override
	public boolean findDemandeurById(long demandeurId) {
		if(demandeurRepository.findById(demandeurId) != null)
			return true;
		return false;
	}


	@Override
	public Demandeur retreiveDemandeur(Long demandeId) {
		
		return null;
	}
	
	
	
}
