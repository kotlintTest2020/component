package com.liangjz.test.myapplication.model;

import android.content.Context;

import com.liangjz.test.myapplication.model.dao.DaoMaster;
import com.liangjz.test.myapplication.model.dao.DaoSession;


public class DatabaseManager {
    private static volatile DatabaseManager mInstance;
    private Context mContext;
    private final String DB_NAME = "test.db";
    private DaoSession mSession;
    private DaoMaster.DevOpenHelper mHelper;

    private DatabaseManager(){

    }
    public static DatabaseManager getInstance(){
        if(mInstance == null){
            synchronized (DatabaseManager.class){
                if(mInstance == null){
                    mInstance = new DatabaseManager();
                }
            }
        }
        return mInstance;
    }

    public void init(Context context){
        if(mContext == null){
            this.mContext = context;
        }
    }
    private DaoMaster.DevOpenHelper getDaoMaster(){
        mHelper =  new DaoMaster.DevOpenHelper(mContext,DB_NAME,null);
        return mHelper;
    }

    public DaoSession getDaosession(){
        if(mSession ==null){
            mSession = new DaoMaster(getDaoMaster().getWritableDatabase()).newSession();
        }
        return mSession;
    }

    public void close(){
        closeHelper();
        closeSession();
    }

    private void closeSession() {
        if(mSession != null){
            mSession.clear();
            mSession = null;
        }
    }

    private void closeHelper() {
        if(mHelper != null){
            mHelper.close();
            mHelper = null;
        }
    }


}
