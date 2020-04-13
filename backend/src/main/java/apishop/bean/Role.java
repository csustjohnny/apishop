package apishop.bean;

import java.io.Serializable;

public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5244288298702801619L;
	private int id;
	private String role;//角色
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", " + (role != null ? "role=" + role : "") + "]";
	}
	
}
