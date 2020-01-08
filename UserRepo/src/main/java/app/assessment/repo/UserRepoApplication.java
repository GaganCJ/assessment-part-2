package app.assessment.repo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRepoApplication.class, args);
	}
}
