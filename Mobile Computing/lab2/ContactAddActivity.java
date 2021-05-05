package com.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactAddActivity extends AppCompatActivity {

    EditText firstEditText, lastEditText, phoneEditText;
    Button addButton;
    String stringFirstname, stringLastname, stringPhone;

    ContactsDB contactsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_add);


        contactsDB = new ContactsDB(ContactAddActivity.this);

        firstEditText = (EditText) findViewById(R.id.firsteditText);
        lastEditText = (EditText) findViewById(R.id.lasteditText);
        phoneEditText = (EditText) findViewById(R.id.numbereditText);
        addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stringFirstname = firstEditText.getText().toString();
                stringLastname = lastEditText.getText().toString();
                stringPhone = phoneEditText.getText().toString();

                if (stringFirstname.length() > 0 && stringLastname.length() > 0 && stringPhone.length() > 0) {

                    String contactType = getIntent().getStringExtra("contact_type");

                    contactsDB.getWritableDatabase();
                    long id = contactsDB.insertContact(stringFirstname, stringLastname, stringPhone, contactType);

                    if (id>0)
                    {
                        Toast.makeText(ContactAddActivity.this,"Contact Added Successfully",Toast.LENGTH_LONG).show();
                        firstEditText.setText("");
                        lastEditText.setText("");
                        phoneEditText.setText("");
                    }

                    contactsDB.close();

                } else {
                    Toast.makeText(ContactAddActivity.this, "Fields must not be empty", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
