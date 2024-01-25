package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Pet;
import com.lbg.demo.services.PetServices;

@RestController
public class PetController {

	private PetServices service;

	public PetController(PetServices service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Pet> createPet(@RequestBody Pet newPet) {
		return this.service.createPet(newPet);
	}

	@GetMapping("/get")
	public List<Pet> getPets() {
		return this.service.getPets();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Pet> getPet(@PathVariable int id) {
		return this.service.getPet(id);
	}

	@PatchMapping("/patch/{id}")
	public ResponseEntity<Pet> patchPet(@PathVariable int id, @RequestBody Pet petDetails) {
		return this.service.patchPet(id, petDetails);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deletePet(@PathVariable int id) {
		return this.service.deletePet(id);
	}

}
