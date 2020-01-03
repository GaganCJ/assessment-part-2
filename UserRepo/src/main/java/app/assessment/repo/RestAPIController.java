package app.assessment.repo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.discovery.DiscoveryClient;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping(value="/getUserValid")
	public String loginValidation(@RequestParam int userid, @RequestParam String password, @RequestParam String level, HttpServletResponse response, HttpSession session) {
		
		ArrayList<UserBean> users = findAllUsers();
		for (UserBean u1 : users) {
			if (u1.getUserId() == userid) {
				if (u1.getPassword().equals(password)) {
					session.setAttribute("user", u1);
					if (u1.get_userAccess().name().equals(level)) {
						if (u1.get_userAccess().name() == "Admin") {
							String url = conClient.getNextServerFromEureka("ADMIN-SERVICE", false).getHomePageUrl();
							try {
								response.sendRedirect(url+"/tableview");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							String url = conClient.getNextServerFromEureka("REGISTER-SERVICE", false).getHomePageUrl();
							try {
								response.sendRedirect(url+"/register");
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
		return "404";
	}
	
	@GetMapping(value = "/userId")
	public String getSessionUserId(HttpSession session) {
		userSession = (UserBean) session.getAttribute("user");
		return Integer.toString(userSession.getUserId());
	}
	
	@GetMapping(value = "/logout")
	public String logOutUser(HttpServletRequest request) {
		request.getSession().invalidate();
		String url = conClient.getNextServerFromEureka("REGISTER-SERVICE", false).getHomePageUrl();
		return "<html>" + "<head>" + "<title>Redirecting...</title>" + "</head>" + "<body>"
				+ "You have been logged out..!! " + "<a href='"+url+"'>Click here to login again..!!</a>" + "</body>"
				+ "</html>";
	}

}
