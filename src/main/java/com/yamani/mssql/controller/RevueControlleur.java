package com.yamani.mssql.controller;


import java.util.Optional;
import java.util.ArrayList;
import java.util.List;


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

import com.yamani.mssql.model.Revue;
import com.yamani.mssql.repository.RevueRepository;


@RestController
@RequestMapping("/revue")
public class RevueControlleur {

	
	@Autowired
	RevueRepository revueRepository;

	@PostMapping("/addRevue")
	public ResponseEntity<Revue> createrevue(@RequestBody Revue revue) {
		System.out.println(revue);
		System.out.println(revue.getNbrExpl());

		try {
			Revue _revue = revueRepository
					.save(new Revue(revue.getTitre(), revue.getPrix(),revue.getNbrExpl(), revue.getAuteur(),revue.getTypeDoc(), revue.getDisponible()));
			return new ResponseEntity<>(_revue, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/getRevue/{id}")
	public ResponseEntity<Revue> getrevueById(@PathVariable("id") long id) {
		try {
		Optional<Revue> revueData = revueRepository.findById(id);

		if (revueData.isPresent()) {
			return new ResponseEntity<>(revueData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping("/listeRevue")
	public ResponseEntity<List<Revue>> getAllrevue(@RequestParam(required = false) String title) {
		try {
			List<Revue> revue = new ArrayList<Revue>();

			
				revueRepository.findAll().forEach(revue::add);
			
			if (revue.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(revue, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteRevue/{id}")
	public ResponseEntity<HttpStatus> deleterevue(@PathVariable("id") long id) {
		try {
			revueRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/updateRevue/{id}")
	public ResponseEntity<Revue> updaterevue(@PathVariable("id") long id, @RequestBody Revue revue) {
		try {
		Optional<Revue> revueData = revueRepository.findById(id);

		if (revueData.isPresent()) {
			Revue _revue = revueData.get();
			_revue.setTitre(revue.getTitre());
			_revue.setPrix(revue.getPrix());
			_revue.setNbrExpl(revue.getNbrExpl());
			_revue.setAuteur(revue.getAuteur());
			_revue.setTypeDoc(revue.getTypeDoc());
			_revue.setDisponible(revue.getDisponible());

			return new ResponseEntity<>(revueRepository.save(_revue), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
