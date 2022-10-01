package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.CV;
import com.example.demo.services.CVService;

@RestController
public class CVController {

	@Autowired
	private CVService cvService;	
	
	@RequestMapping(method = RequestMethod.POST,value =("/create/user/{userId}/cv"))
	public void createCV(@PathVariable Integer userId,@RequestBody CV cv) {
		cvService.add(userId,cv);
	}
	
	@RequestMapping("/getAll/cvs")
	public List <CV>  getAllCVs(){
		return cvService.getAllCVs();	
	}

	@RequestMapping("/getAll/user/{userId}/cvs")
	public List <CV>  getAllUserCVs(@PathVariable Integer userId){
		return cvService.getAllUserCVs(userId);	
	}
	
	@RequestMapping("/get/cv/{cvId}")
	public CV getCV(@PathVariable Integer cvId) {
		return cvService.getCV(cvId);
	}
	
	@RequestMapping(method =RequestMethod.PUT,value="/update/user/{userId}/cv/{cvId}")
	public void updateCV(@PathVariable Integer userId,@PathVariable Integer cvId,@RequestBody CV cv) {
		cvService.updateCV(userId,cvId,cv);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/delete/cv/{cvId}")
	public void deleteCV(@PathVariable Integer cvId) {
		cvService.deleteCV(cvId);
	}
}
