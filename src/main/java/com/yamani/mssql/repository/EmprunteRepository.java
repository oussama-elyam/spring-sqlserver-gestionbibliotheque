package com.yamani.mssql.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yamani.mssql.model.Emprunte;

@Repository("EmprunteRepository")
public interface EmprunteRepository extends JpaRepository<Emprunte, Long> {

	
	//List<Emprunter> findByAdherent(Adherent adherent);
  
}
