package com.lettle.test;

import com.lettle.util.Browser;
import com.lettle.util.View;
import com.lettle.view.LoginView;

/**
 *
 * 增删改查的标准程序
 * 这个程序稍微改动一下可以变成许多管理系统的模型，也可以做网站管理
 * 2020-6-26   --Powered by Lettle
 *
 */
public class TestMain {
	
	public static void main(String[] args) {
		View LoginView = new LoginView();
		Browser browser = Browser.getInstance();
		browser.showView(LoginView);  //先登录
	}
}
