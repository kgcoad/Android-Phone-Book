package com.example.kgphonedirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class WelcomeScreen extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        iv = findViewById(R.id.imv);
        Thread obj = new Thread(){
            public void run() {
                try {
                    sleep(3000);

                    Intent i = new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);

                    finish();
                } catch (Exception e) {

                }
            }
        };

        obj.start();
    }
}