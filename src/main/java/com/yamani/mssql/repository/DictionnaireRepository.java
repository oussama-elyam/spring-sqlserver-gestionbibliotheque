package com.yamani.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yamani.mssql.model.Dictionnaire;

@Repository("DictionnaireRepository")
public interface DictionnaireRepository extends JpaRepository<Dictionnaire, Long> {
  
}
