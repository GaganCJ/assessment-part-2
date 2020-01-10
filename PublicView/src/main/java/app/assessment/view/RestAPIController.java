package app.assessment.view;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestAPIController {

	@Autowired
	private DiscoveryClient conClient;
	
	@Value("${pivotal.assessmentrepo.name}")
	protected String assessmentrepo;
	
	@Value("${pivotal.userrepo.name}")
	protected String userrepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(value="/putLoginData")
	public String sendLoginData(@RequestParam int userid, @RequestParam String password, @RequestParam String level) {
		ArrayList<String> userData = new ArrayList<>();
		userData.add(0,Integer.toString(userid));
		userData.add(1,password);
		userData.add(2,level);
		HttpEntity<?> httpData = new HttpEntity<ArrayList<String>>(userData);
		List<ServiceInstance> instances=conClient.getInstances(userrepo);
		URI uri=instances.get(0).getUri();
		String url = uri.toString()+"/getUserValid";
		ResponseEntity<?> result = restTemplate.exchange(url, HttpMethod.POST, httpData, String.class);
		return result.getBody().toString();
	}
	
}
