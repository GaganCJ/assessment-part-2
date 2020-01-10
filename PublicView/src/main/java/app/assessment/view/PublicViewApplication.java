package app.assessment.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class PublicViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicViewApplication.class, args);
	}
	
	@Controller
	public class ViewController {

		@RequestMapping(value = "/register")
		public String registerPage(HttpServletRequest request) {
			return "Choose_Assessment";
		}
		
		@RequestMapping(value = "/")
		public String loginUser() {
			return "login";
		}
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
