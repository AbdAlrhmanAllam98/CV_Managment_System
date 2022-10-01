package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Section;

public interface SectionRepository extends CrudRepository<Section,Integer> {
	public List<Section> findByCvId(Integer cvId);

}
