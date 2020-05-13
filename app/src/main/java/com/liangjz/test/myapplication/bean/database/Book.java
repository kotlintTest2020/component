package com.liangjz.test.myapplication.bean.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Book {
    @Id(autoincrement = true)
    private Long _id;
    @NotNull
    private String name;
    private String color;
    private int cout;
    private String price;
    @Generated(hash = 653854920)
    public Book(Long _id, @NotNull String name, String color, int cout,
            String price) {
        this._id = _id;
        this.name = name;
        this.color = color;
        this.cout = cout;
        this.price = price;
    }
    @Generated(hash = 1839243756)
    public Book() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getCout() {
        return this.cout;
    }
    public void setCout(int cout) {
        this.cout = cout;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

}
