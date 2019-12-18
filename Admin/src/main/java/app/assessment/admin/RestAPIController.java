package app.assessment.admin;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.EurekaClient;

@RestController
public class RestAPIController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient conClient;

	@GetMapping(value="/tableview")
	public String tableView(HttpServletRequest request) throws JsonProcessingException {
		String url = conClient.getNextServerFromEureka("ASSESSMENT-REPOSITORY", false).getHomePageUrl();
		ArrayList<?> regList = restTemplate.getForEntity(url+"/findAllReg", java.util.ArrayList.class).getBody();
		ObjectMapper obj = new ObjectMapper();
		String jsonStr = "";
		jsonStr = obj.writeValueAsString(regList);
		return jsonStr;
	}
}
