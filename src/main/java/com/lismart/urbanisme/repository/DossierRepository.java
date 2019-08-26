package com.lismart.urbanisme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lismart.urbanisme.model.Dossier;

public interface DossierRepository extends JpaRepository<Dossier, Long> {
	
}
