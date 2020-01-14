package app.assessment.view;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String sendLoginData(@RequestBody Object loginObj) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<?> httpData = new HttpEntity<Object>(loginObj,headers);
		List<ServiceInstance> instances=conClient.getInstances(userrepo);
		URI uri=instances.get(0).getUri();
		String url = uri.toString()+"/getUserValid";
		ResponseEntity<?> result = restTemplate.exchange(url, HttpMethod.POST, httpData, String.class);
		return result.getBody().toString();
	}
	
	@PostMapping(value="/postRegDetails")
	public String sendRegDetails(@RequestBody Object regObj) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<?> httpData = new HttpEntity<Object>(regObj,headers);
		List<ServiceInstance> instances=conClient.getInstances(assessmentrepo);
		URI uri=instances.get(0).getUri();
		String url = uri.toString()+"/regOne";
		ResponseEntity<?> result = restTemplate.exchange(url, HttpMethod.POST, httpData, String.class);
		return result.getBody().toString();
	}
	
	@GetMapping(value="/getUserId")
	public String getUserId() {
		List<ServiceInstance> instances=conClient.getInstances(userrepo);
		URI uri=instances.get(0).getUri();
		String url = uri.toString()+"/userId";
		ResponseEntity<?> result = restTemplate.getForEntity(url, String.class);
		return result.getBody().toString();
	}
	
	@RequestMapping(value="/getOut")
	public void getOut() {
		List<ServiceInstance> instances=conClient.getInstances(userrepo);
		URI uri=instances.get(0).getUri();
		String url = uri.toString()+"/logout";
		restTemplate.getForEntity(url, void.class);
	}
}
