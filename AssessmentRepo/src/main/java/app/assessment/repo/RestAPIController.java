package app.assessment.repo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIController {

	@Autowired
	private AssessRepo assessRepo;
	
	@GetMapping(value="/findAllReg")
	public ArrayList<RegisterBean> findAllRegister(){
		ArrayList<RegisterBean> register = (ArrayList<RegisterBean>) assessRepo.findAll();
		return register;
	}
}
