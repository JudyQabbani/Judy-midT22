package com.example.judy_midt1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name, Email,PID,Number;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bttnAdd = (Button) findViewById(R.id.bttnAdd);
        Name = (EditText) findViewById(R.id.name);
        Email = (EditText) findViewById(R.id.email);
        PID = (EditText) findViewById(R.id.ID);
        Number = (EditText) findViewById(R.id.phonenum);
        Button act1_2=(Button)findViewById(R.id.bt2_1);
        Button act1_3=(Button)findViewById(R.id.bt3_1);
        db = new DatabaseHelper(this);


        act1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1tos2= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(s1tos2);
            }
        });

        act1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s1tos3= new Intent(MainActivity.this,MainActivity3.class);
                startActivity(s1tos3);
            }
        });


        bttnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String ID = PID.getText().toString();
                String number = Number.getText().toString();
                if (name.isEmpty() || email.isEmpty() || ID.isEmpty() || number.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all boxes",
                            Toast.LENGTH_LONG).show();
                } else {
                    if (!db.addData(name, email)) {
                        Toast.makeText(MainActivity.this, "Insertion failed", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Insertion Successful", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });





    }}