package app.assessment.repo;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitialLoader implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private AssessRepo assessRepo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		RegisterBean tbl1 = new RegisterBean(1088,"Java",LocalDate.of(2019, 12, 12),"TECH");
		assessRepo.save(tbl1);
		
		RegisterBean tbl2 = new RegisterBean(2192,"Python",LocalDate.of(2019, 12, 13),"TECH");
		assessRepo.save(tbl2);
		
		RegisterBean tbl3 = new RegisterBean(3122,"C++",LocalDate.of(2019, 12, 14),"TECH");
		assessRepo.save(tbl3);
		
		RegisterBean tbl4 = new RegisterBean(1088,"Step Plus",LocalDate.of(2019, 12, 15),"BEHV");
		assessRepo.save(tbl4);
	}
}
