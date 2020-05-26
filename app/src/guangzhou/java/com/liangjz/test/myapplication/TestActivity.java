package com.liangjz.test.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import com.liangjz.test.myapplication.service.CalcuService;
import com.liangjz.test.myapplication.service.IMyAidlInterface;
import com.liangjz.test.myapplication.service.MessengerService;
import com.liangjz.test.myapplication.service.MyIntentService;

public class TestActivity extends Activity{
    private final static String TAG = TestActivity.class.getClass().getSimpleName();
    public final static String BROCAST = "MY_BROCAST";
    private ServiceConnection mConn;
    private ServiceConnection mConn1;
    IMyAidlInterface iinterface;
    private MyReceiver myReceiver;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerReceiver(myReceiver = new MyReceiver(),new IntentFilter(BROCAST));
        setContentView(R.layout.activity_main);
        test();
        startIntentService();
        bindMessengerService();
    }

    /**
     * 启动intentservice
     */
    private void startIntentService() {
        Intent i = new Intent(this, MyIntentService.class);
        startService(i);
        startService(i);
    }

    private void test() {
        Intent i = new Intent();
        i.setClass(this,CalcuService.class);
        bindService(i, mConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                System.out.println("app-test:onServiceConnected");
                iinterface = IMyAidlInterface.Stub.asInterface(service);
                try {
                    iinterface.setServiceString("test");
                    System.out.println("app-test:getPhoneList" + iinterface.getPhoneList().size());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                System.out.println("app-test:onServiceDisconnected");
            }
        },BIND_AUTO_CREATE);
    }

    class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String name = intent.getStringExtra("name");
            System.out.println("app-test:TestActivity MyReceiver receive:" + name);
        }
    }
    private void bindMessengerService(){
        Intent i = new Intent(this, MessengerService.class);
        bindService(i, mConn1 = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Messenger serviceMessenger = new Messenger(service);
                Message msg = Message.obtain();
                msg.what = 1;
                msg.arg1 = 1111111;
                msg.replyTo = mMessenger;
                try {
                    serviceMessenger.send(msg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        },BIND_AUTO_CREATE);
    }
    Messenger mMessenger = new Messenger(new Handler(){
        @Override
        public void handleMessage(Message msgFromService) {
            super.handleMessage(msgFromService);
            switch (msgFromService.what){
                case 1:
                    System.out.println("Messenger client receive from service:" + msgFromService.arg1);
                    break;
            }
        }
    });

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(myReceiver != null){
            unregisterReceiver(myReceiver);
        }
        unbindService(mConn);
        unbindService(mConn1);
    }
}
