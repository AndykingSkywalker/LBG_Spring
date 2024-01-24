package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

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
	public String createPet(@RequestBody Pet newPet) {
		this.pets.add(newPet);
		return pets.toString();
	}

	@GetMapping("/get")
	public List<Pet> getPets() {
		return pets;
	}

	@GetMapping("/get/{id}")
	public Pet getPet(@PathVariable int id) {
		return this.pets.get(id);
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
