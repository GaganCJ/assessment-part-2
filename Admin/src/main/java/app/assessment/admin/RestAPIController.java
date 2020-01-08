package app.assessment.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.discovery.EurekaClient;

@RestController
public class RestAPIController {
		
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient conClient;

	@GetMapping(value="/tableview")
	public ResponseEntity<?> tableView(HttpServletRequest request) {
		//request.getSession().getAttribute("user");
		String url = conClient.getNextServerFromEureka("ASSESSMENT-REPOSITORY", false).getHomePageUrl();
		String result = restTemplate.getForObject(url + "/findAllReg", String.class);
		return ResponseEntity.ok(result);
	}
}
