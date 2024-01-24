package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Pet;

@RestController
public class PetController {

	private List<Pet> pets = new ArrayList<>();

	@PostMapping("/create")
	public ResponseEntity<Pet> createPet(@RequestBody Pet newPet) {
		this.pets.add(newPet);

		Pet body = this.pets.get(this.pets.size() - 1);

		return new ResponseEntity<Pet>(body, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public List<Pet> getPets() {
		return pets;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Pet> getPet(@PathVariable int id) {
		if (id < 0 || id >= this.pets.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Pet found = this.pets.get(id);

		return ResponseEntity.ok(found);
	}

	@PatchMapping("/patch/{id}")
	public Pet patchPet(@PathVariable int id, @RequestBody Pet petDetails) {
		Pet pet = this.pets.get(id);
		pet.setName(petDetails.getName());
		pet.setAge(petDetails.getAge());
		return pet;
	}

	@DeleteMapping("/delete/{id}")
	public String deletePet(@PathVariable int id) {
		Pet pet = this.pets.remove(id);
		return "Deleted pet: " + pet;
	}

}
