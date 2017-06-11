package com.gelo.serviceexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TheDatabase theDatabase;
    String fname = "Angelo";
    String lname = "Umali";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theDatabase = new TheDatabase(this);


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
