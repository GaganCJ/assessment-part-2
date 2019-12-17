package app.assessment.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping(value = "/admin")
	public String returnList() {
		return "AssessmentList";
	}

}
