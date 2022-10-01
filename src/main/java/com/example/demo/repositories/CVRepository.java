package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.CV;

public interface CVRepository extends CrudRepository<CV, Integer> {
	public List<CV> findByUserEmail(String userEmail);
}
