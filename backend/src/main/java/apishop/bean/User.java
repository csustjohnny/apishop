package apishop.bean;

import java.io.Serializable;

public class User implements Serializable{


	private static final long serialVersionUID = -5244288298702801619L;
	private int id;
	private String userName;//用户名
	private String password;//密码
	private String salt;//盐
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	@Override
	public String toString() {
		return "{id:" + id + ", " + (userName != null ? "userName:" + userName + ", " : "")
				+ (password != null ? "password:" + password + ", " : "") + (salt != null ? "salt:" + salt : "") + "}";
	}
	
	
}
