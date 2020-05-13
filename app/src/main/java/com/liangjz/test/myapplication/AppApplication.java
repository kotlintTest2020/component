package com.liangjz.test.myapplication;

import android.app.Application;
import android.os.Environment;

import com.squareup.leakcanary.LeakCanary;
import com.liangjz.test.myapplication.model.DatabaseManager;

import java.io.File;
import java.io.IOException;

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        DatabaseManager.getInstance().init(getApplicationContext());
    }

    @Override
    public File getDatabasePath(String name) {
        boolean sdExist = Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState());
        if (sdExist) {
            String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Teligen-test/db/";
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            File newFile = new File(path + name);
            if (!newFile.exists()) {
                try {
                    newFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    return super.getDatabasePath(name);
                }
            }
            return newFile;
        } else {
            return super.getDatabasePath(name);
        }
    }
}
