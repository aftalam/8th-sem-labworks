package com.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button addButton,viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton= (Button) findViewById(R.id.addcontactButton);
        viewButton= (Button) findViewById(R.id.viewcontactButton);

        addButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        
        int id=v.getId();
        if (id==R.id.addcontactButton)
        {
            Intent addintent=new Intent(MainActivity.this,AddContatctHomeActivity.class);
            startActivity(addintent);

        }else if (id==R.id.viewcontactButton){
            Intent addintent=new Intent(MainActivity.this,ViewContactHomeActivity.class);
            startActivity(addintent);
        }
    }
}
