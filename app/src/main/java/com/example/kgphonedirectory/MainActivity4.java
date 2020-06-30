package com.example.kgphonedirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {

    EditText too,subj,mail;
    Button bmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        too = findViewById(R.id.editto);
        subj = findViewById(R.id.editsub);
        mail = findViewById(R.id.editmail);
        bmail = findViewById(R.id.buttonmail);

        Bundle bundle = getIntent().getExtras();
        String emailb = bundle.getString("mail");

        too.setText(emailb);

        bmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to = too.getText().toString();
                String sub = subj.getText().toString();
                String maill = mail.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT,sub);
                email.putExtra(Intent.EXTRA_TEXT,maill);

                email.setType("message/rfc822");
                startActivity(email);
            }
        });


    }
}