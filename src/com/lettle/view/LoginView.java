package com.lettle.view;

import com.lettle.service.UserService;
import com.lettle.util.View;

import java.util.Scanner;

public class LoginView implements View {

	@Override
	public void show() {
		Scanner input = new Scanner(System.in);
		System.out.println("************************************************");
		System.out.println("***            登录       By Lettle          ***");
		System.out.println("************************************************");
		
		System.out.print("账号");
		String uname = input.next();
		System.out.print("密码");
		String upass = input.next();
		
		UserService us = UserService.getInstance();
		us.checkLogin(uname, upass);
		
		
	}

	@Override
	public void setData(Object[] obj) {
		
	}
	
}
