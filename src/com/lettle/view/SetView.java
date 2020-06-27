package com.lettle.view;

import com.lettle.service.UserService;
import com.lettle.util.View;

import java.util.Scanner;

/**
 * 改
 */
public class SetView implements View {
    @Override
    public void show() {
        Scanner input = new Scanner(System.in);

        System.out.println("************************************************");
        System.out.println("修改一个记录");
        System.out.println("************************************************");

        String uname = input.next();
        String upass = input.next();

        if(UserService.getInstance().setUserPassword(uname, upass)){
            System.out.println("修改 "+uname+" 的记录成功！");

            MainView mainView = new MainView();
            mainView.show();
        }
    }

    @Override
    public void setData(Object[] obj) {

    }
}
