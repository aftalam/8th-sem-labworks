package com.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewContactHomeActivity extends AppCompatActivity {

    ListView contactTypeList;

    String[] typeArray = {"Family", "Friends", "Residence", "College", "Others"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact_home);

        contactTypeList = (ListView) findViewById(R.id.contactTypeList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ViewContactHomeActivity.this, android.R.layout.simple_list_item_1, typeArray);

        contactTypeList.setAdapter(adapter);

        contactTypeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(ViewContactHomeActivity.this,DisplayContactsActivity.class);
                intent.putExtra("contact_type",parent.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }
}
