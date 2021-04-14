package com.example.judy_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText Search;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button bttnFind = (Button) findViewById(R.id.bttnFind);
        Search = (EditText) findViewById(R.id.search);
        Button act2_1=(Button)findViewById(R.id.bt1_2);
        Button act2_3=(Button)findViewById(R.id.bt3_2);
        db = new DatabaseHelper(this);


        act2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s2tos1= new Intent(MainActivity2.this,MainActivity.class);
                startActivity(s2tos1);
            }
        });

        act2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s2tos3= new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(s2tos3);
            }
        });

        bttnFind.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            String id = Search.getText().toString();
            if(id.isEmpty()){
                Toast.makeText(MainActivity2.this, "empty",
                        Toast.LENGTH_LONG).show(); }
            else{
                Cursor cursor = db.getSpecificResult(id);
                if(cursor.getCount() <= 0){
                    Toast.makeText(MainActivity2.this, "Item is not exist", Toast.LENGTH_LONG).show();
                }

          else {
                String CID = cursor.getString(0); String CName = cursor.getString(1); String CQuan = cursor.getString(2);
                Toast.makeText(MainActivity2.this, CID + ", " + CName + ", " + CQuan, Toast.LENGTH_LONG).show();
            } }}
    });

    }
}