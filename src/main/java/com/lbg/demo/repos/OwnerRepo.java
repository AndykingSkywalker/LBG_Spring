package com.lbg.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Integer> {

}
