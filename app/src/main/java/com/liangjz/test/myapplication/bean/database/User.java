package com.liangjz.test.myapplication.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id(autoincrement = true)
    private long _id;
    @NotNull
    public String name;
    public int age;
    @Generated(hash = 1036686942)
    public User(long _id, @NotNull String name, int age) {
        this._id = _id;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public long get_id() {
        return this._id;
    }
    public void set_id(long _id) {
        this._id = _id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
