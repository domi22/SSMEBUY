package com.del.pojo;

import java.io.Serializable;
import java.util.List;

public class Indent implements Serializable {
	private Integer indentid;//订单编号
	private String userid;//用户编号
	private String indentime;//下单时间
	private String indentstatu;//订单状态
	private List<User> userlist;
	private List<T_status> statuslist;
	
	
	
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public List<T_status> getStatuslist() {
		return statuslist;
	}
	public void setStatuslist(List<T_status> statuslist) {
		this.statuslist = statuslist;
	}
	
	
	
	public Indent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIndentid() {
		return indentid;
	}
	public void setIndentid(int indentid) {
		this.indentid = indentid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getIndentime() {
		return indentime;
	}
	public void setIndentime(String indentime) {
		this.indentime = indentime;
	}
	public String getIndentstatu() {
		return indentstatu;
	}
	public void setIndentstatu(String indentstatu) {
		this.indentstatu = indentstatu;
	}
	
	
	
}
