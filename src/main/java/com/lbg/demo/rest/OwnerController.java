package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Owner;
import com.lbg.demo.services.OwnerServices;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	private OwnerServices service;

	public OwnerController(OwnerServices service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Owner> createOwner(@RequestBody Owner newOwner) {
		return this.service.createOwner(newOwner);
	}

	@GetMapping("/get")
	public List<Owner> getOwners() {
		return this.service.getOwners();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Owner> getOwner(@PathVariable int id) {
		return this.service.getOwner(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Owner> updateOwner(@PathVariable int id, @RequestBody Owner ownerDetails) {
		return this.service.updateOwner(id, ownerDetails);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteOwner(@PathVariable int id) {
		return this.service.deleteOwner(id);
	}
}
