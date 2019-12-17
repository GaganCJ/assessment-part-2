package app.assessment.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@RestController
public class RestAPIController {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private EurekaClient conClient;

	@GetMapping(value="/tableview")
	public String tableView() {
		String url = conClient.getNextServerFromEureka("ASSESSMENT-REPOSITORY", false).getHomePageUrl();
		return restTemplate().getForEntity(url+"/findAllReg", String.class).getBody();
	}
}
