package app.assessment.repo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_tbl")
public class UserBean {

	@Id
	private int userId;
	
	@NotNull
	private String password;
	
	public enum userAccess{
			Admin,
			Employee
	};
	
	@NotNull
	private userAccess _userAccess;

	public UserBean() {
		super();
	}

	public UserBean(int userId, @NotNull String password, @NotNull userAccess _userAccess) {
		super();
		this.userId = userId;
		this.password = password;
		this._userAccess = _userAccess;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public userAccess get_userAccess() {
		return _userAccess;
	}

	public void set_userAccess(userAccess _userAccess) {
		this._userAccess = _userAccess;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", password=" + password + ", _userAccess=" + _userAccess + "]";
	}
}
