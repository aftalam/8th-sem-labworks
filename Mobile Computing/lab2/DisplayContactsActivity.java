package com.phonebook;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayContactsActivity extends AppCompatActivity {

    ContactsDB contactsDB;
    List<Contacts> contactsList;

    ListView contactListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);

        contactsDB = new ContactsDB(DisplayContactsActivity.this);

        contactListview = (ListView) findViewById(R.id.contactList);


        contactListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DisplayContactsActivity.this);
                alertDialog.setTitle("  Select Your Option?");
               // alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        contactsDB.deleteContact(contactsList.get(position).getId());

                        displaycontacts();
                    }
                });
                alertDialog.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent=new Intent(DisplayContactsActivity.this,UpdateContactActivity.class);
                        intent.putExtra("id",contactsList.get(position).getId());
                        intent.putExtra("firstname",contactsList.get(position).getFirstname());
                        intent.putExtra("lastname",contactsList.get(position).getLastname());
                        intent.putExtra("phone",contactsList.get(position).getPhonenumber());
                        startActivity(intent);
                    }
                });

                alertDialog.show();

                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        displaycontacts();

    }

    public class MycontactsAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return contactsList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.contacts, null);

            TextView firstName = (TextView) convertView.findViewById(R.id.firsttextView);
            TextView lastName = (TextView) convertView.findViewById(R.id.lastnametextView);
            TextView phoneNumber = (TextView) convertView.findViewById(R.id.phonetextView);

            firstName.setText(contactsList.get(position).getFirstname());
            lastName.setText(contactsList.get(position).getLastname());
            phoneNumber.setText(contactsList.get(position).getPhonenumber());

            return convertView;
        }
    }

    public void displaycontacts() {

        String contactTypeString = getIntent().getStringExtra("contact_type");

        contactTypeString = contactTypeString.toLowerCase().toString();

        contactsList = contactsDB.getAllcontacts(contactTypeString.trim());

        if (contactsList.size() > 0) {
            contactListview.setAdapter(new MycontactsAdapter());

        } else {
            contactListview.setAdapter(new MycontactsAdapter());

            Toast.makeText(DisplayContactsActivity.this, "No contacts Added", Toast.LENGTH_LONG).show();
        }
    }
}
