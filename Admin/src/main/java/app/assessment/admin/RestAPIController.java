package app.assessment.admin;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestAPIController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient conClient;

	@Value("${pivotal.assessmentrepo.name}")
	protected String assessmentRepo;
	
	@GetMapping(value="/tableview")
	public ResponseEntity<?> tableView(HttpServletRequest request) {
		request.getSession().getAttribute("user");
		List<ServiceInstance> instances=conClient.getInstances(assessmentRepo);
		URI uri=instances.get(0).getUri();
		String url = uri.toString()+"/findAllReg";
		String result = restTemplate.getForObject(url, String.class);
		return ResponseEntity.ok(result);
	}
}
