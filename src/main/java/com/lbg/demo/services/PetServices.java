package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Pet;
import com.lbg.demo.repos.PetRepo;

@Service
public class PetServices {

	private PetRepo repo;

	public PetServices(PetRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Pet> createPet(Pet newPet) {
		Pet created = this.repo.save(newPet);
		return new ResponseEntity<Pet>(created, HttpStatus.CREATED);
	}

	public List<Pet> getPets() {
		return this.repo.findAll();
	}

	public ResponseEntity<Pet> getPet(int id) {

		Optional<Pet> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
		}
		Pet body = found.get();

		return ResponseEntity.ok(body);

	}

	public ResponseEntity<Pet> patchPet(int id, Pet petDetails) {
		Optional<Pet> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
		}
		Pet existing = found.get();

		if (petDetails.getName() != null) {
			existing.setName(petDetails.getName());
		}

		if (petDetails.getAge() != null) {
			existing.setAge(petDetails.getAge());
		}

		if (petDetails.getOwner() != null) {
			existing.setOwner(petDetails.getOwner());
		}

		Pet updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean deletePet(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

}
