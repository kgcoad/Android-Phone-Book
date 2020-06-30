package com.example.kgphonedirectory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "friends";
    private static final String TABLE_NAME = "kumarfriends";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_CONTACT = "contact";
    private static final String COLUMN_EMAIL ="email";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_ITEM_TABLE = "CREATE TABLE    " + TABLE_NAME + "( "
                + COLUMN_ID + "  INTEGER PRIMARY KEY, " + COLUMN_NAME + "  TEXT, "+ COLUMN_CONTACT + "  TEXT, "+ COLUMN_EMAIL + " TEXT)";
        db.execSQL(CREATE_ITEM_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void insertLabel(String name, String contact, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_CONTACT, contact);
         values.put(COLUMN_EMAIL,email);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public List<Contact>  getAllContacts()
    {
        List<Contact> list = new ArrayList<Contact>();
        String selectQuery = "SELECT  * FROM  " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);   // ResultSet class
        if (cursor.moveToFirst())
        {
            do {

              Contact c= new Contact();

              c.setName(cursor.getString(1));
                c.setContact(cursor.getString(2));

                c.setEmail(cursor.getString(3));
            list.add(c);




                     } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;


    }




    public List<String> getAllLabels()
    {
        List<String> list = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM  " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);   // ResultSet class
        if (cursor.moveToFirst())
        {
            do {
                list.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
    }
}






