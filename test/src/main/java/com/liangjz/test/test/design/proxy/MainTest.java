package com.liangjz.test.test.design.proxy;

public class MainTest {
    public static void main(String[] args) {
        IUser user = new UserImpl();
        IUser userProxy = (IUser) new ProxyHandler().newProxy(user);
        userProxy.addUser("d");
    }
}
