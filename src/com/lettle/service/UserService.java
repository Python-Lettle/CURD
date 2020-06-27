package com.lettle.service;

import com.lettle.domain.User;
import com.lettle.util.ArrayBox;
import com.lettle.util.Browser;
import com.lettle.store.UserStore;
import com.lettle.util.View;
import com.lettle.view.*;

/**
 * 管理User的service
 */
public class UserService {
	
	private UserService() {}
	private static UserService us = new UserService();
	public static UserService getInstance() {
		return us;
	}
	//-------------------------------------------------\\
	
	private User loginUser ; //记录当前登录的用户

	/**
	 * 检查账号密码是否正确
	 * @param uname 用户名
	 * @param upass 密码
	 */
	public void checkLogin(String uname,String upass) {
		UserStore us = UserStore.getInstance();
		User user = us.findUserByName(uname);
		
		if(user != null && user.getUpass().equals(upass) && user.isAdmin()) {
			//登录成功
			this.loginUser = user;
			View view = new MainView();
			Browser browser = Browser.getInstance();
			browser.showView(view);  //去主界面
			return;
		}
		
		//登录失败
		View v = new LoginView();
		Browser b = Browser.getInstance();
		b.showView(v);  //回到登录页面
	}

	/**
	 * 获取当前登录的用户
	 * @return User 登录的用户
	 */
	public User getLoginUser(){
		return loginUser;
	}

	/**
	 * 添加一个User
	 * @param uname 用户名
	 * @param upass 密码
	 * @return boolean
	 */
	public boolean addUser(String uname, String upass) {
		return UserStore.getInstance().addUser(uname, upass);
	}

	/**
	 * 根据用户名删除User
	 * @param uname 用户名
	 * @return boolean
	 */
	public boolean deleteUserByName(String uname) {
		return UserStore.getInstance().deleteUserByName(uname);
	}

	/**
	 * 修改信息(password)
	 * @param uname 用户名
	 * @return boolean
	 */
	public boolean setUserPassword(String uname, String upass) {
		return UserStore.getInstance().setUserPassword(uname, upass);
	}

	/**
	 * 获取User数组
	 * @return ArrayBox
	 */
	public ArrayBox getUserList() {
		return UserStore.getInstance().getUserList();
	}

	/**
	 * 登出管理员
	 * @return boolean
	 */
	public void logout() {
		loginUser = null;

		LoginView loginView = new LoginView();
		loginView.show();
	}

}
