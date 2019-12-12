package app.assessment.repo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "registered_tbl")
public class RegisterBean {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int ID;

	@NotNull
	private int userId;

	@NotNull
	private String skillTopic;

	@NotNull
	private LocalDate scheduled_date;

	@NotNull
	private String assessment_type;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date utilTimestamp;
	
	Date date = new Date();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSkillTopic() {
		return skillTopic;
	}

	public void setSkillTopic(String skillTopic) {
		this.skillTopic = skillTopic;
	}

	public LocalDate getScheduled_date() {
		return scheduled_date;
	}

	public void setScheduled_date(LocalDate scheduled_date) {
		this.scheduled_date = scheduled_date;
	}

	public String getAssessment_type() {
		return assessment_type;
	}

	public void setAssessment_type(String assessment_type) {
		this.assessment_type = assessment_type;
	}

	public java.util.Date getUtilTimestamp() {
		return utilTimestamp;
	}
	
	public void setUtilTimestamp() {
		this.utilTimestamp = new Timestamp(date.getTime());
	}

	public RegisterBean(@NotNull int userId, @NotNull String skillTopic, @NotNull LocalDate scheduled_date,
			@NotNull String assessment_type) {
		super();
		this.userId = userId;
		this.skillTopic = skillTopic;
		this.scheduled_date = scheduled_date;
		this.assessment_type = assessment_type;
		this.utilTimestamp = new Timestamp(date.getTime());
	}
	
	public RegisterBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RegisterBean [ID=" + ID + ", userId=" + userId + ", skillTopic=" + skillTopic + ", scheduled_date="
				+ scheduled_date + ", assessment_type=" + assessment_type + ", utilTimestamp=" + utilTimestamp + "]";
	}
}
