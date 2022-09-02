package com.yamani.mssql.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yamani.mssql.model.Adherent;
import com.yamani.mssql.model.Document;
import com.yamani.mssql.model.Emprunte;
import com.yamani.mssql.repository.AdherentRepository;
import com.yamani.mssql.repository.DocumentRepository;
import com.yamani.mssql.repository.EmprunteRepository;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/emprunte")
public class EmprunteController {
	

	@Autowired
	EmprunteRepository emprunteRepository;
	@Autowired
	AdherentRepository adherentRepository;
	@Autowired
	DocumentRepository documentRepository;

	@RequestMapping(path = "/addEmprunte/{id}/{cin}",method = RequestMethod.POST)
	public ResponseEntity<Emprunte> createemprunte(@PathVariable("id") long doc_id ,@PathVariable("cin") long ad_id) {
		
		
		long millis = System.currentTimeMillis();  
	    Date date_emprunte = new Date(millis);      
	    System.out.println(date_emprunte.toString());  
	    
	    Date date_retoure = new Date(date_emprunte.getTime()+(1000*60*60*24*5));	    
	    System.out.println(date_retoure.toString());  


	    try {
		Optional<Adherent> adherent = adherentRepository.findById(ad_id);
		Optional<Document> document = documentRepository.findById(doc_id);

			if (adherent.isPresent() && document.isPresent()) { 
				Adherent _adherent = adherent.get();
				Document _document = document.get();
			
				Emprunte _emprunte = emprunteRepository.save(new Emprunte(date_emprunte, date_retoure, _adherent, _document));
				
				return new ResponseEntity<>(_emprunte, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/deleteEmprunte/{id}")
	public ResponseEntity<HttpStatus> deleteadherent(@PathVariable("id") long id) {
		try {
			emprunteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listeEmprunte")
	public ResponseEntity<List<Emprunte>> getAllempruntes() {
		try {
			List<Emprunte> emprunte = new ArrayList<Emprunte>();

			
				emprunteRepository.findAll().forEach(emprunte::add);
			
			if (emprunte.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(emprunte, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getEmprunte/{id}")
	public ResponseEntity<Emprunte> getemprunteById(@PathVariable("id") long id) {
		try {
		Optional<Emprunte> emprunteData = emprunteRepository.findById(id);

		if (emprunteData.isPresent()) {
			return new ResponseEntity<>(emprunteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

	
}
