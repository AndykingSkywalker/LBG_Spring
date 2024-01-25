package com.lbg.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Pet;

@Service
public class PetServices {

	private List<Pet> pets = new ArrayList<>();

	public ResponseEntity<Pet> createPet(Pet newPet) {
		this.pets.add(newPet);

		Pet body = this.pets.get(this.pets.size() - 1);

		return new ResponseEntity<Pet>(body, HttpStatus.CREATED);
	}

	public List<Pet> getPets() {
		return pets;
	}

	public ResponseEntity<Pet> getPet(int id) {
		if (id < 0 || id >= this.pets.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Pet found = this.pets.get(id);

		return ResponseEntity.ok(found);
	}

	public Pet patchPet(int id, Pet petDetails) {
		Pet pet = this.pets.get(id);
		pet.setName(petDetails.getName());
		pet.setAge(petDetails.getAge());
		return pet;
	}

	public String deletePet(int id) {
		Pet pet = this.pets.remove(id);
		return "Deleted pet: " + pet;
	}

}
