package app.assessment.registration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableDiscoveryClient
public class RegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}
	
	@Controller
	public class ViewController {

		@RequestMapping(value = "/register")
		public String registerPage(HttpServletRequest request) {
			request.getSession().getAttribute("user");
			return "Choose_Assessment";
		}
	}

}
