package app.assessment.admin;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.discovery.EurekaClient;

@RestController
public class RestAPIController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient conClient;

	@GetMapping(value="/tableview")
	public String tableView(HttpServletRequest request) throws JsonProcessingException {
		request.getSession().getAttribute("user");
		String url = conClient.getNextServerFromEureka("ASSESSMENT-REPOSITORY", false).getHomePageUrl();
		ResponseEntity<String> result = restTemplate.getForEntity(url+"/findAllReg", String.class);
		if(result.getStatusCode() == HttpStatus.OK) {
			return result.getBody().toString();
		}else {
			return null;
		}
	}
}
