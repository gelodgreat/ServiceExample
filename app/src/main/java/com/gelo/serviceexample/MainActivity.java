package com.gelo.serviceexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gelo.serviceexample.database.TheDatabase;
import com.gelo.serviceexample.services.TheService;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    TheDatabase theDatabase;
    String fname = "Angelo";
    String lname = "Umali";

    @BindView(R.id.btn_intentservices)
    Button btn_gotointentservices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theDatabase = new TheDatabase(this);

//        btn_gotointentservices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), IntentServicesExample.class);
//                startActivity(intent);
//            }
//        });
    }

    public void startService(View view) {
        Intent intent = new Intent(this, TheService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, TheService.class);
        stopService(intent);
    }

    public void populateDB(View view) {
        addData();
    }

    public void gotoIntentServices(View view) {
        Intent intent = new Intent(this, IntentServicesExample.class);
        startActivity(intent);
    }

    public void addData() {
        try {

            for (int i = 0; i < 20; i++) {
                boolean isInserted = theDatabase.insertData(fname, lname);
                if (isInserted = true) {
                    Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
