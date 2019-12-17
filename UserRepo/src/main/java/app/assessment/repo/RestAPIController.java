package app.assessment.repo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RestAPIController {
	
	@Autowired
	private UserRepo userRepo; 
	
	@GetMapping(value="/findAll")
	public ArrayList<UserBean> findAllUsers() {
		ArrayList<UserBean> users = (ArrayList<UserBean>) userRepo.findAll();
		return users;
	}

}
