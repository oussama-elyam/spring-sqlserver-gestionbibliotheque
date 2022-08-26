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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yamani.mssql.model.Livre;
import com.yamani.mssql.repository.LivreRepository;


@RestController
@RequestMapping("/livre")
public class LivreController {
	
	@Autowired
	LivreRepository livreRepository;

	@PostMapping("/addLivre")
	public ResponseEntity<Livre> createlivre(@RequestBody Livre livre) {
		System.out.println(livre);
		System.out.println(livre.getNbrExpl());

		try {
			Livre _livre = livreRepository
					.save(new Livre(livre.getTitre(), livre.getPrix(),livre.getNbrExpl(), livre.getAuteur(), livre.getDisponible(),livre.getPages()));
			return new ResponseEntity<>(_livre, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getLivre/{id}")
	public ResponseEntity<Livre> getlivreById(@PathVariable("id") long id) {
		try {
		Optional<Livre> livreData = livreRepository.findById(id);

		if (livreData.isPresent()) {
			return new ResponseEntity<>(livreData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping("/listeLivre")
	public ResponseEntity<List<Livre>> getAllLivre(@RequestParam(required = false) String title) {
		try {
			List<Livre> livre = new ArrayList<Livre>();

			
				livreRepository.findAll().forEach(livre::add);
			
			if (livre.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(livre, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteLivre/{id}")
	public ResponseEntity<HttpStatus> deletelivre(@PathVariable("id") long id) {
		try {
			livreRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/updateLivre/{id}")
	public ResponseEntity<Livre> updatelivre(@PathVariable("id") long id, @RequestBody Livre livre) {
		try {
		Optional<Livre> livreData = livreRepository.findById(id);

		if (livreData.isPresent()) {
			Livre _livre = livreData.get();
			_livre.setTitre(livre.getTitre());
			_livre.setPrix(livre.getPrix());
			_livre.setNbrExpl(livre.getNbrExpl());
			_livre.setAuteur(livre.getAuteur());
			_livre.setDisponible(livre.getDisponible());
			_livre.setPages(livre.getPages());

			return new ResponseEntity<>(livreRepository.save(_livre), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
