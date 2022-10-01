package com.example.demo.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.CV;
import com.example.demo.entities.User;
import com.example.demo.repositories.CVRepository;

@Service
public class CVService {

	@Autowired
	CVRepository cvRepository;
	
	@Autowired
	UserService userService;
	
	public void add(Integer userId,CV cv) {
		cv.setUser(userService.getUser(userId));
		cvRepository.save(cv);
	}
	
	public List<CV> getAllUserCVs(Integer userId){
		List<CV> cvs=new ArrayList<>();
		User user = userService.getUser(userId);
		cvRepository.findByUserEmail(user.getEmail()).forEach(cvs::add);
		return cvs;
	}
	
	public List<CV> getAllCVs(){
		List<CV> cvs=new ArrayList<>();
		cvRepository.findAll().forEach(cvs::add);
		return cvs ;
	}
	
	public CV getCV(int cvId) {
		return cvRepository.findById(cvId).get();
	}
	
	public void updateCV(Integer userId,Integer cvId,CV cv) {
		cv.setId(cvId);
		cv.setUser(userService.getUser(userId));
		cvRepository.save(cv);	
	}
	
	public void deleteCV(Integer cvId) {
		cvRepository.deleteById(cvId);
	}
}
