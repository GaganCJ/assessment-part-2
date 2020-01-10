package app.assessment.repo;

import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIController {

	@Autowired
	private AssessRepo assessRepo;

	@GetMapping(value = "/findAllReg")
	public ArrayList<RegisterBean> findAllRegister() {
		ArrayList<RegisterBean> register = (ArrayList<RegisterBean>) assessRepo.findAll();
		return register;
	}

	@PostMapping(value = "/regOne",consumes = "application/json")
	public ResponseEntity<?> regAssessment(@Valid @RequestBody RegisterBean regNewBean, Errors error) {

		String stderr = "";
		if (error.hasErrors()) {
			stderr = error.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(","));
			return ResponseEntity.badRequest().body(stderr);
		} else {
			assessRepo.save(regNewBean);
			stderr = "success";
			return ResponseEntity.ok(stderr);
		}
	}
}
