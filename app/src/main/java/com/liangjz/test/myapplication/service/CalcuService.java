package com.liangjz.test.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.liangjz.test.myapplication.TestActivity;
import com.liangjz.test.myapplication.bean.Phone;

import java.util.ArrayList;
import java.util.List;

public class CalcuService extends Service {
    private final static String TAG = CalcuService.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return mBinder;
    }

    public CalcuService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("app-test:service onCreate");
        new MyAsyncTask().execute("");
    }

    class MyAsyncTask extends AsyncTask<String,Integer,String> {

        @Override
        protected String doInBackground(String... strings) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendBroadcast();
            return "doInBackground";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            System.out.println("onPostExecute:" + s);
            stopSelf();
        }
    }

    private void sendBroadcast(){
        Intent i = new Intent();
        i.setAction(TestActivity.BROCAST);
        i.putExtra("name","from service");
        sendBroadcast(i);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("app-test:service onDestroy");
    }
    private Binder mBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void setServiceString(String str) throws RemoteException {
            System.out.println("app-test:service setServiceString:" + str);
        }

        @Override
        public List<Phone> getPhoneList() throws RemoteException {
            List<Phone> phones = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Phone p = new Phone();
                phones.add(p);
            }
            return phones;
        }
    };
}
