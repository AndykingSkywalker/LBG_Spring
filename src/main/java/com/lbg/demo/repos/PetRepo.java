package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Pet;

public interface PetRepo extends JpaRepository<Pet, Integer> {

}
