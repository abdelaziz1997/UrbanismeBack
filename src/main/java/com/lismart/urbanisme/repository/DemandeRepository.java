package com.lismart.urbanisme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lismart.urbanisme.model.Demande;


public interface DemandeRepository extends JpaRepository<Demande,Long>{
	Demande findByreference(String reference);
	@Query("from Demande as d where id in ( select MAX(id)  FROM Demande) ")
	Demande MaxID();
}
