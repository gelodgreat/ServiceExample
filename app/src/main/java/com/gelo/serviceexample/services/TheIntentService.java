package com.gelo.serviceexample.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.gelo.serviceexample.database.TheDatabase;

/**
 * Created by Angelo Umali on 6/11/2017.
 */

public class TheIntentService extends IntentService {
    TheDatabase theDatabase;

    public TheIntentService() {
        super("intent_service_thread");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this, "Intent Service Started", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Intent Service Destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int secs = 5000;
        synchronized (this) {
            try {
                wait(secs);
//                theDatabase.truncatetable();
                Toast.makeText(this, "Data Truncated!", Toast.LENGTH_SHORT).show();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
