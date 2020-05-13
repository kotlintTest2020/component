package com.liangjz.test.test.design.proxy;

public class UserImpl implements IUser{
    @Override
    public void addUser(String userName) {
        System.out.println("UserImp addUser:" + userName);
    }
}
