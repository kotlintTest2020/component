package com.liangjz.test.myapplication.model;

import com.liangjz.test.myapplication.bean.database.Book;
import com.liangjz.test.myapplication.model.dao.BookDao;

import java.util.ArrayList;
import java.util.List;

public class ModelData {

    private BookDao mBookDao;
    private static volatile ModelData mInstance;
    private ModelData(){
        mBookDao = DatabaseManager.getInstance().getDaosession().getBookDao();
    }
    public static ModelData getInstance(){
        if(mInstance == null){
            synchronized (ModelData.class){
                if(mInstance == null){
                    mInstance = new ModelData();
                }
            }
        }
        return mInstance;
    }


    public List<Book> getBookList(){
        List<Book> bookList = new ArrayList<>();
        bookList =  mBookDao.queryBuilder().list();
        if( bookList.size() <= 0){
//            insert mock data;
            for (int i = 0; i < 10; i++) {
                Book book = new Book(null,"name:" + i,"color:"+i,i,"price:"+"i");
                mBookDao.insert(book);
                bookList.add(book);
            }
        }
        return bookList;
    }

}
