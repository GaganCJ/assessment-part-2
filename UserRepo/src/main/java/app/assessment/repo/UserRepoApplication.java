package app.assessment.repo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class UserRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRepoApplication.class, args);
	}
	
	@Bean
	public UserBean userSession() {
		return new UserBean();
	}
}
