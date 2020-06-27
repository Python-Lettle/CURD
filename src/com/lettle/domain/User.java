package com.lettle.domain;

import com.lettle.util.Record;

/**
 * 一条记录(一个用户)
 * @author Lettle
 */
public class User implements Record {
	private String uname;  //用户名
	private String upass;  //密码
	
	public User() {}
	public User(String uname, String upass) {
		this.uname = uname;
		this.upass = upass;
	}

	/**
	 * 非管理员标识
	 */
	public boolean isAdmin() {
		return false;
	}

	/**
	 * get && set
	 */

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}


}
