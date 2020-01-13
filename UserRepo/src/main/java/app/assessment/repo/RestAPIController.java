package app.assessment.repo;

import org.springframework.web.bind.annotation.RestController;

import app.assessment.pojo.LoginObject;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RestAPIController {
	
	@Autowired
	private UserRepo userRepo; 
	
	public ArrayList<UserBean> findAllUsers() {
		ArrayList<UserBean> users = (ArrayList<UserBean>) userRepo.findAll();
		return users;
	}
	
	@Autowired
	private UserBean userSession;

	@Autowired
	private DiscoveryClient conClient;
	
	@Value("${pivotal.adminservice.name}")
	protected String adminservice;
	
	@Value("${pivotal.registerservice.name}")
	protected String registerservice;
	
	@PostMapping(value="/getUserValid", consumes = "application/json")
	public String loginValidation(@Valid @RequestBody LoginObject loginObj, HttpServletResponse response, HttpSession session, Errors error) {
		
		ArrayList<UserBean> users = findAllUsers();
		for (UserBean u1 : users) {
			if (u1.getUserId() == loginObj.getUserid()) {
				if (u1.getPassword().equals(loginObj.getPassword())) {
					session.setAttribute("user", u1);
					if (u1.get_userAccess().name().equals(loginObj.getLevel())) {
						if (u1.get_userAccess().name() == "Admin") {
							List<ServiceInstance> instances=conClient.getInstances(adminservice);
							URI uri=instances.get(0).getUri();
							String url = uri.toString()+"/admin";
							try {
								response.sendRedirect(url);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							List<ServiceInstance> instances=conClient.getInstances(registerservice);
							URI uri=instances.get(0).getUri();
							String url = uri.toString()+"/register";
							try {
								response.sendRedirect(url);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				} else {
					return "Wrong Password";
				}
			}
		}
		return "Not Found";
	}
	
	@GetMapping(value = "/userId")
	public String getSessionUserId(HttpSession session) {
		userSession = (UserBean) session.getAttribute("user");
		return Integer.toString(userSession.getUserId());
	}
	
	@GetMapping(value = "/logout")
	public void logOutUser(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		List<ServiceInstance> instances=conClient.getInstances(registerservice);
		URI uri=instances.get(0).getUri();
		String url = uri.toString();
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
