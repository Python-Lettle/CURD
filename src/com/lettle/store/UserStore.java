package com.lettle.store;

import com.lettle.domain.Administrator;
import com.lettle.domain.User;
import com.lettle.service.UserService;
import com.lettle.util.ArrayBox;

/**
 * 储存用户的store
 */
public class UserStore {

	private UserStore() {}
	private static UserStore us = new UserStore();
	public static UserStore getInstance() {
		return us;
	}
	//--------------------------------------------------\\
	
	//装载用户
	private ArrayBox users = new ArrayBox();
	{
		User u1 = new User("lr", "123");
		User u2 = new User("路飞", "233");
		User u3 = new User("巨涂", "666");
		users.add(u1);
		users.add(u2);
		users.add(u3);

		Administrator a1 = new Administrator("Lettle", "let");
		users.add(a1);
	}

	/**
	 *
	 * @param uname 用户名
	 * @return User 找到的用户 未找到返回null
	 */
	public User findUserByName(String uname) {
		for (int i = 0; i < users.size(); i++) {
			User user = (User) users.get(i);
			if (user.getUname().equals(uname)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * 添加一个User
	 * @param uname 用户名
	 * @param upass 密码
	 * @return boolean
	 */
	public boolean addUser(String uname, String upass) {
		return users.add(new User(uname, upass));
	}

	/**
	 * 根据用户名删除User
	 * @param uname 用户名
	 * @return boolean
	 */
	public boolean deleteUserByName(String uname) {
		for (int i = 0; i < users.size(); i++) {
			User user = (User) users.get(i);
			if (user.getUname().equals(uname)) {
				users.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * 修改User信息(Password)
	 * @param uname 用户名
	 * @return boolean
	 */
	public boolean setUserPassword(String uname, String upass) {
		for (int i = 0; i < users.size(); i++) {
			User user = (User) users.get(i);
			if (user.getUname().equals(uname)) {
				user.setUpass(upass);
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取User数组
	 * @return ArrayBox
	 */
	public ArrayBox getUserList() {
		return users;
	}

}
