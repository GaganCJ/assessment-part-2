package app.assessment.repo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RestAPIController {
	
	@Autowired
	private UserRepo userRepo; 
	
	public ArrayList<UserBean> findAllUsers() {
		ArrayList<UserBean> users = (ArrayList<UserBean>) userRepo.findAll();
		return users;
	}
	
	@GetMapping(value="/findAllUsers")
	public ResponseEntity<?> getRegList() {
		return ResponseEntity.ok(findAllUsers());
	}

}
