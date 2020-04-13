package apishop.bean;

import java.io.Serializable;

//api的参数
public class ApiParam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1056120778682510326L;
	private int id;//参数id
	private String paramName;//参数名称
	private String paramType;//参数类型
	private int aid;//所属的api的id
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamType() {
		return paramType;
	}
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	@Override
	public String toString() {
		return "ApiParam [id=" + id + ", " + (paramName != null ? "paramName=" + paramName + ", " : "")
				+ (paramType != null ? "paramType=" + paramType + ", " : "") + "aid=" + aid + "]";
	}
	
	
	
}
