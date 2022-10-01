package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Section;
import com.example.demo.repositories.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	CVService cvService;
	
	public void add(Integer cvId,Section section) {
		section.setCv(cvService.getCV(cvId));
		sectionRepository.save(section);
	}
	
	public List<Section> getAllCVSections(Integer cvId){
		List<Section> sections=new ArrayList<>();
		sectionRepository.findByCvId(cvId).forEach(sections::add);;
		return sections ;
	}
	
	public List<Section> getAllSections(){
		List<Section> sections=new ArrayList<>();
		sectionRepository.findAll().forEach(sections::add);;
		return sections ;
	}
	
	public Section getSection(Integer sectionId) {
		return sectionRepository.findById(sectionId).get();
	}
	
	public void updateSection(Integer cvId,Integer sectionId,Section section) {
		section.setId(sectionId);
		section.setCv(cvService.getCV(cvId));
		sectionRepository.save(section);
		
	}

	public void deleteSection(Integer sectionId) {
		sectionRepository.deleteById(sectionId);
	}
}
