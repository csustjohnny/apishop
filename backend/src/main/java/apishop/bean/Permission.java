package apishop.bean;

import java.io.Serializable;

public class Permission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String url;//url路径
	private String action;//该url的动作名称(比如：新增用户)
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + ", " + (url != null ? "url=" + url + ", " : "")
				+ (action != null ? "action=" + action : "") + "]";
	}
	
	
}
