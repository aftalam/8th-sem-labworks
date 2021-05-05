package com.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateContactActivity extends AppCompatActivity {

    EditText firstEditText, lastEditText, phoneEditText;
    Button updateButton;
    String stringFirstname, stringLastname, stringPhone;
    int Id;

    ContactsDB contactsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);


        contactsDB = new ContactsDB(UpdateContactActivity.this);



        firstEditText = (EditText) findViewById(R.id.firsteditText);
        lastEditText = (EditText) findViewById(R.id.lasteditText);
        phoneEditText = (EditText) findViewById(R.id.numbereditText);
        updateButton = (Button) findViewById(R.id.updateButton);

        stringFirstname=getIntent().getStringExtra("firstname");
        stringLastname=getIntent().getStringExtra("lastname");
        stringPhone=getIntent().getStringExtra("phone");
        Id=getIntent().getIntExtra("id",0);

        firstEditText.setText(stringFirstname);
        lastEditText.setText(stringLastname);
        phoneEditText.setText(stringPhone);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stringFirstname = firstEditText.getText().toString();
                stringLastname = lastEditText.getText().toString();
                stringPhone = phoneEditText.getText().toString();

                if (stringFirstname.length() > 0 && stringLastname.length() > 0 && stringPhone.length() > 0) {



                    contactsDB.updateContact(Id,stringFirstname,stringLastname,stringPhone);

                    Toast.makeText(UpdateContactActivity.this, "Updated Successfully", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(UpdateContactActivity.this, "Fields must not be empty", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
