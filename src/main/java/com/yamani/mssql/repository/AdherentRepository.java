package com.yamani.mssql.repository;

import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yamani.mssql.model.Adherent;

public interface AdherentRepository extends JpaRepository<Adherent, Long> {
	Optional<Adherent> findByCin(String cin);
}
