package com.yamani.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yamani.mssql.model.Livre;

@Repository("LivreRepository")

public interface LivreRepository extends JpaRepository<Livre, Long> {

}
