package com.example.kgphonedirectory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView l1;

String contact;
String username;
String useremail;
String usercontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        l1 = findViewById(R.id.kumarlist);


        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        List<String> labels = db.getAllLabels( );

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, labels);

        l1.setAdapter(dataAdapter);

l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
contact= parent.getItemAtPosition(position).toString();
        DatabaseHandler  db= new DatabaseHandler(getApplicationContext());
        List<Contact>  data= db.getAllContacts();
        for(Contact c: data)
        {
            username= c.getName();
            if(contact.equals(username))
            {
                useremail=c.getEmail();
                usercontact= c.getContact();
                Toast.makeText(getApplicationContext(), usercontact+"\n"+useremail,Toast.LENGTH_LONG).show();
                break;
            }
        }
    }
});

        /*b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });*/

        registerForContextMenu(l1);

    }

    @Override
    public void onCreateContextMenu(ContextMenu m, View v, ContextMenu.ContextMenuInfo m1) {
        super.onCreateContextMenu(m, v, m1);

        m.setHeaderTitle("Select your choice");
        m.add(0,v.getId(),0,"calluser");
        m.add(0,v.getId(),0,"smsuser");
        m.add(0,v.getId(),0,"emailuser");

    }
    @Override
    public boolean onContextItemSelected(MenuItem i) {
String title= i.getTitle().toString();
        if (title.equals("calluser"))
        {
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:" + usercontact));
            startActivity(call);
            Toast.makeText(getApplicationContext(),usercontact,Toast.LENGTH_LONG).show();
        }

        if(title.equals("smsuser"))
        {
            Intent i1= new Intent(getApplicationContext(), MainActivity3.class);
            i1.putExtra("mob",usercontact);
            startActivity(i1);
        }

        if(title.equals("emailuser"))
        {
            Intent i2 = new Intent(getApplicationContext(),MainActivity4.class);
            i2.putExtra("mail",useremail);
            startActivity(i2);
        }



        return true;
    }







}