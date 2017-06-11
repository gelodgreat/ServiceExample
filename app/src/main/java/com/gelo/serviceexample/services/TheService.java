package com.gelo.serviceexample.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.gelo.serviceexample.database.TheDatabase;

/**
 * Created by Angelo Umali on 6/11/2017.
 */

public class TheService extends Service {

    TheDatabase theDatabase;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new TheThread(startId));
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        theDatabase = new TheDatabase(this);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    final class TheThread implements Runnable {
        int serviceId;

        TheThread(int serviceId) {
            this.serviceId = serviceId;

        }

        @Override
        public void run() {

            int secs = 5000;
            synchronized (this) {
                try {
                    wait(secs);


                    theDatabase.truncatetable();
                    //                    Toast.makeText(TheService.this, "Truncated", Toast.LENGTH_SHORT).show();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopSelf(this.serviceId);
            }

        }
    }
}
