package app.assessment.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import app.assessment.repo.UserBean.userAccess;

@Component
public class InitialLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepo userRepo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		UserBean user1 = new UserBean(1001, "user1001", userAccess.Admin);
		userRepo.save(user1);

		UserBean user2 = new UserBean(1088, "user1088", userAccess.Employee);
		userRepo.save(user2);

		UserBean user3 = new UserBean(2192, "user2192", userAccess.Employee);
		userRepo.save(user3);

		UserBean user4 = new UserBean(3122, "user3122", userAccess.Employee);
		userRepo.save(user4);
	}
}