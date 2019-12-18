package app.assessment.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@RestController
public class RestAPIController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient conClient;
	
	@PostMapping(value="/getUserValid")
	public String loginValidation(@RequestParam int userid, @RequestParam String password, @RequestParam String level) {
		return null;

	}
}
