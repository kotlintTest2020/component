package com.liangjz.test.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class MessengerService extends Service {
    Messenger messenger = new Messenger(new Handler(){
        @Override
        public void handleMessage(Message msgFromClient) {
            super.handleMessage(msgFromClient);
            switch (msgFromClient.what){
                case 1:
                    System.out.println("Messenger service,receiver client:" + msgFromClient.arg1);
                    Message msg = Message.obtain();
                    msg.what = 1;
                    msg.arg1 = 2222222;
                    try {
                        msgFromClient.replyTo.send(msg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    });
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

}
