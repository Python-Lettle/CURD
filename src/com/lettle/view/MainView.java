package com.lettle.view;

import com.lettle.service.UserService;
import com.lettle.util.View;

import java.util.Scanner;

public class MainView implements View {

	@Override
	public void show() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("************************************************");
		System.out.println("当前用户: " + UserService.getInstance().getLoginUser().getUname() + "(Administrator)");
		System.out.println("1.增加记录");
		System.out.println("2.删除记录");
		System.out.println("3.修改记录");
		System.out.println("4.查询记录");
		System.out.println("5.登出管理员");
		System.out.println("************************************************");
		System.out.print("选择操作项:");

		//操作项返回值
		int no = input.nextInt();

		//显示界面
		switch (no) {
		case 1:
			AddView addView = new AddView();
			addView.show();
			break;
		case 2:
			DelView delView = new DelView();
			delView.show();
			break;
		case 3:
			SetView setView = new SetView();
			setView.show();
			break;
		case 4:
			FindView findView = new FindView();
			findView.show();
			break;
		case 5:
			UserService.getInstance().logout();
			break;
		}
	}

	@Override
	public void setData(Object[] obj) {
		
	}

}
