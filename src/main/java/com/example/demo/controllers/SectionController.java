package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Section;
import com.example.demo.services.SectionService;

@RestController
public class SectionController {
	
	@Autowired
	private SectionService sectionService;
	
	@RequestMapping(method = RequestMethod.POST,value =("/create/cv/{cvId}/section"))
	public void createSection(@PathVariable Integer cvId,@RequestBody Section section) {
		sectionService.add(cvId,section);
	}
	
	@RequestMapping("/getAll/sections")
	public List <Section>  getAllSections(){
		return sectionService.getAllSections();	
	}

	@RequestMapping("/getAll/cv/{cvId}/sections")
	public List <Section>  getAllCVSections(@PathVariable Integer cvId){
		return sectionService.getAllCVSections(cvId);	
	}
	
	@RequestMapping("/get/section/{sectionId}")
	public Section getSection(@PathVariable Integer sectionId) {
		return sectionService.getSection(sectionId);
	}
	
	
	@RequestMapping(method =RequestMethod.PUT,value="/update/cv/{cvId}/section/{sectionId}")
	public void updateSection(@PathVariable Integer cvId,@PathVariable Integer sectionId,@RequestBody Section section) {
		sectionService.updateSection(cvId,sectionId,section);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/delete/section/{sectionId}")
	public void deleteSection(@PathVariable Integer sectionId) {
		sectionService.deleteSection(sectionId);
	}
}
