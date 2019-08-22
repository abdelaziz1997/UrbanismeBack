package com.lismart.urbanisme.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lismart.urbanisme.model.Demandeur;




public interface DemandeurRepository extends JpaRepository<Demandeur, Long> {
	
}
