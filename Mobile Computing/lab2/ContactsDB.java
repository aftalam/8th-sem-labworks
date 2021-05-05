package com.phonebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ContactsDB extends SQLiteOpenHelper {

    public static String DB_NAME = "PHONEBOOK";
    public static String TABLE_NAME = "contacts";
    public static int VERSION = 1;
    public static String KEY_ID = "id";
    public static String KEY_FIRSTNAME = "firstname";
    public static String KEY_LASTNAME = "lastname";
    public static String KEY_PHONE = "phone";
    public static String KEY_CONTACTTYPE = "contacttype";

    SQLiteDatabase sdb;

    public ContactsDB(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table contacts(id integer primary key autoincrement,firstname text not null,lastname text not null,phone text not null,contacttype text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS messages");
        onCreate(db);
    }

    public long insertContact(String firstname,String lastname,String phonenumber,String contacttype) {

        sdb=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_FIRSTNAME, firstname);
        contentValues.put(KEY_LASTNAME, lastname);
        contentValues.put(KEY_PHONE, phonenumber);
        contentValues.put(KEY_CONTACTTYPE, contacttype);

        return sdb.insert(TABLE_NAME, null, contentValues);

    }
    public void deleteContact(int id)
    {
        sdb=this.getWritableDatabase();

        System.out.println(""+id);

        sdb.execSQL("DELETE FROM contacts WHERE id="+id);

    }
    public void updateContact(int id,String firstname,String lastname,String phone)
    {
        sdb=this.getWritableDatabase();
        System.out.println(""+id);
        sdb.execSQL("UPDATE "+ TABLE_NAME +" SET "+ KEY_FIRSTNAME + " = '"+firstname+"' ,"+KEY_LASTNAME+"= '"+lastname+"' ,"+KEY_PHONE+"= '"+phone+"' WHERE " + KEY_ID +" = "+id);
    }



    public  List<Contacts> getAllcontacts(String contacttype)
    {
        List<Contacts> contactsList=new  ArrayList<Contacts>();

        String selectQuery = "SELECT * FROM " +TABLE_NAME+" WHERE "+KEY_CONTACTTYPE+"='"+contacttype+"'";

      //  String selectQuery = "SELECT * FROM " +TABLE_NAME;

        sdb=this.getReadableDatabase();
        Cursor cursor=sdb.rawQuery(selectQuery,null);

        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();

            do {
                Contacts contacts = new Contacts();

                contacts.setId(Integer.parseInt(cursor.getString(0)));
                contacts.setFirstname(cursor.getString(1));
                contacts.setLastname(cursor.getString(2));
                contacts.setPhonenumber(cursor.getString(3));
                contacts.setContacttype(cursor.getString(4));

                contactsList.add(contacts);

            }while (cursor.moveToNext());
        }

        return contactsList;
    }
}
