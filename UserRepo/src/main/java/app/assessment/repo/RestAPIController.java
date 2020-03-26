package app.assessment.repo;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@SuppressWarnings("unlikely-arg-type")
	@PostMapping(value="/getUserValid", consumes = "application/json")
	public String loginValidation(@Valid @RequestBody UserBean loginObj, HttpServletResponse response, HttpSession session, Errors error) {
		
		ArrayList<UserBean> users = findAllUsers();
		for (UserBean u1 : users) {
			if (u1.getUserId() == loginObj.getUserId()) {
				if (u1.getPassword().equals(loginObj.getPassword())) {
					session.setAttribute("user", u1);
					if (u1.get_userAccess().name().equals(loginObj.get_userAccess())) {
						if (u1.get_userAccess().name() == "Admin") {
							/* send a response to UI so that redirect to admin page works in UI */
							try {
								response.sendRedirect("http://localhost:4200/admin");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							/* send a response to UI so that redirect to register page works in UI */
							try {
								response.sendRedirect("http://localhost:4200/home/register");
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
		/* send a response to UI so that redirect to login page works in UI */
		try {
			response.sendRedirect("http://localhost:4200/home");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
