package com.del.pojo;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;

public class User implements Serializable {
	private Integer userid;
	private Integer userrole;
	private String username;
	private String pwd;
	private String address;
	private String phone;
	private String email;
	private String sex;
//	@Past(message="必须是一个过去的时间")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date birthday;
	private String hdpicpath;
	private String wkpicpath;

public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getUserrole() {
		return userrole;
	}

	public void setUserrole(Integer userrole) {
		this.userrole = userrole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHdpicpath() {
		return hdpicpath;
	}

	public void setHdpicpath(String hdpicpath) {
		this.hdpicpath = hdpicpath;
	}

	public String getWkpicpath() {
		return wkpicpath;
	}

	public void setWkpicpath(String wkpicpath) {
		this.wkpicpath = wkpicpath;
	}

@Override
public String toString() {
	return "User [userid=" + userid + ", userrole=" + userrole + ", username="
			+ username + ", pwd=" + pwd + ", address=" + address + ", phone="
			+ phone + ", email=" + email + ", sex=" + sex + ", birthday="
			+ birthday + ", hdpicpath=" + hdpicpath + ", wkpicpath="
			+ wkpicpath + "]";
}




	

	

}
