package com.lettle.view;

import com.lettle.domain.User;
import com.lettle.service.UserService;
import com.lettle.util.View;

/**
 * 查
 */
public class FindView implements View {
    @Override
    public void show() {

        System.out.println("************************************************");
        System.out.println("当前所有记录如下:");

        Object[] objs = UserService.getInstance().getUserList().toArray();
        User u;
        int i=0;
        for(Object e : objs){
            u = (User)e;
            System.out.println((++i)+". "+u.getUname()+" "+u.getUpass());
        }

        System.out.println("************************************************");

        MainView mainView = new MainView();
        mainView.show();
    }

    @Override
    public void setData(Object[] obj) {

    }
}
