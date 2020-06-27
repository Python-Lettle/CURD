package com.lettle.view;

import com.lettle.service.UserService;
import com.lettle.util.View;

import java.util.Scanner;

/**
 * 删
 */
public class DelView implements View {
    @Override
    public void show() {
        Scanner input = new Scanner(System.in);

        System.out.println("************************************************");
        System.out.println("删除一条记录");
        System.out.println("************************************************");

        System.out.print("输入要删除的用户名:");
        String uname = input.next();

        if(UserService.getInstance().deleteUserByName(uname)){
            System.out.println("删除成功！");
            MainView mainView = new MainView();
            mainView.show();
        }

    }

    @Override
    public void setData(Object[] obj) {

    }
}
