package app.assessment.pojo;

public class LoginObject {

	private int userid;
	private String password;
	private String level;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public LoginObject(int userid, String password, String level) {
		super();
		this.userid = userid;
		this.password = password;
		this.level = level;
	}
}
