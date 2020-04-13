package apishop.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Api implements Serializable{
	
	private static final long serialVersionUID = -5244288298702801619L;
	private int id;//api的id
	private String apiName;//api名称
	private String apiType;//api所属类别
	private String apiAddress;//请求地址
	private String protocol;//请求协议
	private String requestType;//请求方式
	private String requestDataFormat;//请求数据类型
	private String returnDataFormat;//返回的数据类型
	private String outline;//概要说明
    private Date   time;//录入时间
	private String status;//审核状态
	private String publisher;//发布的用户
	private String reviewer;//审核人
	private List<ApiParam> params;//api的参数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getApiType() {
		return apiType;
	}
	public void setApiType(String apiType) {
		this.apiType = apiType;
	}
	public String getApiAddress() {
		return apiAddress;
	}
	public void setApiAddress(String apiAddress) {
		this.apiAddress = apiAddress;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getRequestDataFormat() {
		return requestDataFormat;
	}
	public void setRequestDataFormat(String requestDataFormat) {
		this.requestDataFormat = requestDataFormat;
	}
	public String getReturnDataFormat() {
		return returnDataFormat;
	}
	public void setReturnDataFormat(String returnDataFormat) {
		this.returnDataFormat = returnDataFormat;
	}
	public String getOutline() {
		return outline;
	}
	public void setOutline(String outline) {
		this.outline = outline;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public List<ApiParam> getParams() {
		return params;
	}
	public void setParams(List<ApiParam> params) {
		this.params = params;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Api [id=" + id + ", " + (apiName != null ? "apiName=" + apiName + ", " : "")
				+ (apiType != null ? "apiType=" + apiType + ", " : "")
				+ (apiAddress != null ? "apiAddress=" + apiAddress + ", " : "")
				+ (protocol != null ? "protocol=" + protocol + ", " : "")
				+ (requestType != null ? "requestType=" + requestType + ", " : "")
				+ (requestDataFormat != null ? "requestDataFormat=" + requestDataFormat + ", " : "")
				+ (returnDataFormat != null ? "returnDataFormat=" + returnDataFormat + ", " : "")
				+ (outline != null ? "outline=" + outline + ", " : "") + (time != null ? "time=" + time + ", " : "")
				+ (status != null ? "status=" + status + ", " : "")
				+ (publisher != null ? "publisher=" + publisher + ", " : "")
				+ (reviewer != null ? "reviewer=" + reviewer + ", " : "") + (params != null ? "params=" + params : "")
				+ "]";
	}
	
	
	

}
