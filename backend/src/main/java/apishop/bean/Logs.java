package apishop.bean;

import java.util.Date;

public class Logs {

	private Long id;
	private String userName;//日志产生的用户
	private Date time;//时间（该时间有数据库表时间戳类型字段自动产生）
	private String action;//该日志的操作
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", " + (userName != null ? "userName=" + userName + ", " : "")
				+ (time != null ? "time=" + time + ", " : "") + (action != null ? "action=" + action : "") + "]";
	}
	
	
}
