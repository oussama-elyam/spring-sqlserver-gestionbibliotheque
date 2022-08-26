package com.yamani.mssql.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yamani.mssql.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
  
}
