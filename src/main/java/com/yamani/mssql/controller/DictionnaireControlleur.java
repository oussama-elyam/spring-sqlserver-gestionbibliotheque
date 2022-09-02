package com.yamani.mssql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamani.mssql.model.Dictionnaire;
import com.yamani.mssql.repository.DictionnaireRepository;




@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/dictionnaire")
public class DictionnaireControlleur {

	
	@Autowired
	DictionnaireRepository dictionnaireRepository;

	@PostMapping("/addDictionnaire")
	public ResponseEntity<Dictionnaire> createdictionnaire(@RequestBody Dictionnaire dictionnaire) {
		System.out.println(dictionnaire);
		System.out.println(dictionnaire.getNbrExpl());

		try {
			Dictionnaire _dictionnaire = dictionnaireRepository
					.save(new Dictionnaire(dictionnaire.getTitre(), dictionnaire.getPrix(),dictionnaire.getNbrExpl(), dictionnaire.getAuteur(), dictionnaire.getDisponible(),dictionnaire.getLangue()));
			return new ResponseEntity<>(_dictionnaire, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getDictionnaire/{id}")
	public ResponseEntity<Dictionnaire> getdictionnaireById(@PathVariable("id") long id) {
		try {
		Optional<Dictionnaire> dictionnaireData = dictionnaireRepository.findById(id);

		if (dictionnaireData.isPresent()) {
			return new ResponseEntity<>(dictionnaireData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping("/listeDictionnaire")
	public ResponseEntity<List<Dictionnaire>> getAlldictionnaire() {
		try {
			List<Dictionnaire> dictionnaire = new ArrayList<Dictionnaire>();

			
				dictionnaireRepository.findAll().forEach(dictionnaire::add);
			
			if (dictionnaire.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(dictionnaire, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteDictionnaire/{id}")
	public ResponseEntity<HttpStatus> deletedictionnaire(@PathVariable("id") long id) {
		try {
			dictionnaireRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/updateDictionnaire/{id}")
	public ResponseEntity<Dictionnaire> updatedictionnaire(@PathVariable("id") long id, @RequestBody Dictionnaire dictionnaire) {
		try {
		Optional<Dictionnaire> dictionnaireData = dictionnaireRepository.findById(id);

		if (dictionnaireData.isPresent()) {
			Dictionnaire _dictionnaire = dictionnaireData.get();
			_dictionnaire.setTitre(dictionnaire.getTitre());
			_dictionnaire.setPrix(dictionnaire.getPrix());
			_dictionnaire.setNbrExpl(dictionnaire.getNbrExpl());
			_dictionnaire.setAuteur(dictionnaire.getAuteur());
			_dictionnaire.setDisponible(dictionnaire.getDisponible());
			_dictionnaire.setLangue(dictionnaire.getLangue());

			return new ResponseEntity<>(dictionnaireRepository.save(_dictionnaire), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
