package com.example.kgphonedirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText e5,e6;
    Button bsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        e5 = findViewById(R.id.numberedit);
        e6 = findViewById(R.id.messedit);
        bsms = findViewById(R.id.buttonmess);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("mob");

        e5.setText(data);

        Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();

       bsms.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String data = e5.getText().toString();
               String msg = e6.getText().toString();
               Intent i = new Intent(getApplicationContext(),MainActivity3.class);
               PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, i, 0);
               SmsManager sms = SmsManager.getDefault();
               sms.sendTextMessage(data, null, msg, pi, null);
               Toast.makeText(getApplicationContext(), "sms send successful", Toast.LENGTH_LONG);


           }
       });

    }
}