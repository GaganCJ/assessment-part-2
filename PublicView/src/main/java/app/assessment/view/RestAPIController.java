package app.assessment.view;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import app.assessment.pojo.LoginObject;

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
	public String sendLoginData(@RequestBody LoginObject loginObj) {
		HttpEntity<?> httpData = new HttpEntity<LoginObject>(loginObj);
		List<ServiceInstance> instances=conClient.getInstances(userrepo);
		URI uri=instances.get(0).getUri();
		String url = uri.toString()+"/getUserValid";
		ResponseEntity<?> result = restTemplate.exchange(url, HttpMethod.POST, httpData, String.class);
		return result.getBody().toString();
	}
	
}
