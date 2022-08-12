package com.yamani.mssql.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yamani.mssql.model.Adherent;

public interface AdherentRepository extends JpaRepository<Adherent, Long> {
  //List<Adherent> findByPublished(boolean published);
  //List<Adherent> findByTitleContaining(String title);
}
