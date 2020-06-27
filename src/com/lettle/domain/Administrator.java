package com.lettle.domain;

/**
 * 管理员
 * 本质也是一个User
 */
public class Administrator extends User{

    public Administrator() {}
    public Administrator(String uname, String upass) {
        super(uname, upass);
    }

    /**
     * 管理员标识
     * @return boolean True
     */
    public boolean isAdmin(){
        return true;
    }
}
