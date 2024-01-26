package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Owner;
import com.lbg.demo.repos.OwnerRepo;

@Service
public class OwnerServices {

	private OwnerRepo repo;

	public OwnerServices(OwnerRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Owner> createOwner(Owner newOwner) {
		Owner created = this.repo.save(newOwner);
		return new ResponseEntity<Owner>(created, HttpStatus.CREATED);
	}

	public List<Owner> getOwners() {
		return this.repo.findAll();
	}

	public ResponseEntity<Owner> getOwner(int id) {
		Optional<Owner> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
		}
		Owner body = found.get();
		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Owner> updateOwner(int id, Owner ownerDetails) {
		Optional<Owner> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
		}
		Owner existing = found.get();

		if (ownerDetails.getName() != null) {
			existing.setName(ownerDetails.getName());
		}
		if (ownerDetails.getLocation() != null) {
			existing.setLocation(ownerDetails.getLocation());
		}

		Owner updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

	public boolean deleteOwner(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
