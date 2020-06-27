package com.lettle.view;

import com.lettle.service.UserService;
import com.lettle.util.View;

import java.util.Scanner;

/**
 * 增
 */
public class AddView implements View {

    @Override
    public void show() {
        Scanner input = new Scanner(System.in);

        System.out.println("************************************************");
        System.out.println("增加一个新的记录");
        System.out.println("************************************************");

        System.out.print("输入新用户名:");
        String uname = input.next();
        System.out.print("输入新用户密码:");
        String upass = input.next();

        if(UserService.getInstance().addUser(uname, upass)){
            System.out.println("新建记录 "+uname+" 成功!");
        }else {
            System.out.println("新建记录失败!");
        }

        MainView mainView = new MainView();
        mainView.show();
    }

    @Override
    public void setData(Object[] obj) {

    }
}
