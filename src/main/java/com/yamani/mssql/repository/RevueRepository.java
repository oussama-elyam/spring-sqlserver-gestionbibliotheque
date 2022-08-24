package com.yamani.mssql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yamani.mssql.model.Revue;

@Repository("RevueRepository")
public interface RevueRepository extends JpaRepository<Revue, Long> {

}
