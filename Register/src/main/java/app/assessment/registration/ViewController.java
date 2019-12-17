package app.assessment.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping(value = "/register")
	public String registerPage() {
		return "Choose_Assessment";
	}
}
