package com.gelo.serviceexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gelo.serviceexample.services.TheIntentService;

public class IntentServicesExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_services_example);
    }


    public void startServiceint(View view) {
        Intent intent = new Intent(this, TheIntentService.class);
        startService(intent);

    }


    public void stopServiceint(View view) {
        Intent intent = new Intent(this, TheIntentService.class);
        stopService(intent);
    }
}
