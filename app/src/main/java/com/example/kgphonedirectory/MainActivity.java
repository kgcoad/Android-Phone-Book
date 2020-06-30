package com.example.kgphonedirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

   // Spinner spinner;
    EditText e1,e2,e3;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // spinner = findViewById(R.id.spinner);
        e1 = findViewById(R.id.editText1);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
      //  spinner.setOnItemSelectedListener(this);

      //  loadSpinnerData( );

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String name = e1.getText().toString();
                    String contact = e2.getText().toString();
                    String email = e3.getText().toString();

                    DatabaseHandler db = new DatabaseHandler(getApplicationContext());

                    db.insertLabel(name, contact, email);

                    Toast.makeText(getApplicationContext(), "Successful record data", Toast.LENGTH_LONG).show();

                    // loadSpinnerData();


            }
        });
    }



   /* private void loadSpinnerData()
    {
        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        List<String> labels = db.getAllLabels( );

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);

        spinner.setAdapter(dataAdapter);
    }*/
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {

        String label = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}

