package com.yamani.mssql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamani.mssql.model.Adherent;
import com.yamani.mssql.repository.AdherentRepository;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/adherent")
public class AdherentController {

	@Autowired
	AdherentRepository adherentRepository;

	@GetMapping("/listeAdherent")
	public ResponseEntity<List<Adherent>> getAlladherents() {
		try {
			List<Adherent> adherent = new ArrayList<Adherent>();

			
				adherentRepository.findAll().forEach(adherent::add);
			
			if (adherent.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(adherent, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/adherent/{id}")
	public ResponseEntity<Adherent> getadherentById(@PathVariable("id") long id) {
		try {
		Optional<Adherent> adherentData = adherentRepository.findById(id);

		if (adherentData.isPresent()) {
			return new ResponseEntity<>(adherentData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

	@PostMapping("/addAdherent")
	public ResponseEntity<Adherent> createadherent(@RequestBody Adherent adherent) {
		System.out.println(adherent);
		try {
			Adherent _adherent = adherentRepository
					.save(new Adherent(adherent.getNom(), adherent.getPrenom(),adherent.getAdresse(), adherent.getCin(),adherent.getDate_naiss()));
			return new ResponseEntity<>(_adherent, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/adherent/{id}")
	public ResponseEntity<Adherent> updateadherent(@PathVariable("id") long id, @RequestBody Adherent adherent) {
		try {
		Optional<Adherent> adherentData = adherentRepository.findById(id);

		if (adherentData.isPresent()) {
			Adherent _adherent = adherentData.get();
			_adherent.setNom(adherent.getNom());
			_adherent.setPrenom(adherent.getPrenom());
			_adherent.setAdresse(adherent.getAdresse());
			_adherent.setCin(adherent.getCin());
			_adherent.setDate_naiss(adherent.getDate_naiss());

			return new ResponseEntity<>(adherentRepository.save(_adherent), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteAdherent/{id}")
	public ResponseEntity<HttpStatus> deleteadherent(@PathVariable("id") long id) {
		try {
			adherentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/listeAdherent")
	public ResponseEntity<HttpStatus> deleteAlladherents() {
		try {
			adherentRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/* @GetMapping("/adherents/published")
	public ResponseEntity<List<Adherent>> findByPublished() {
		try {
			List<Adherent> adherents = adherentRepository.findByPublished(true);

			if (adherents.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(adherents, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} */

}
