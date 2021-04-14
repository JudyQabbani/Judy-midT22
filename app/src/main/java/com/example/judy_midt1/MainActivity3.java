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

public class MainActivity3 extends AppCompatActivity {
    EditText input;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button act3_1=(Button)findViewById(R.id.bt3_1);
        Button act3_2=(Button)findViewById(R.id.bt2_3);
        Button bttnView = (Button) findViewById(R.id.bttnView);
        Button bttnDelete = (Button) findViewById(R.id.bttnDelete);
        Button bttnAdd = (Button) findViewById(R.id.bttnAdd);
        input = (EditText) findViewById(R.id.input);
        db = new DatabaseHelper(this);



        act3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s3tos1= new Intent(MainActivity3.this,MainActivity.class);
                startActivity(s3tos1);
            }
        });

        act3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s3tos2= new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(s3tos2);
            }
        });


        bttnDelete.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            String id = input.getText().toString();
            db.Delete(id);
            Toast.makeText(MainActivity3.this, "Successful Delete", Toast.LENGTH_LONG).show();
        } });


        bttnView.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            Cursor cur = db.getListContents(); StringBuffer buffer = new StringBuffer(); while(cur.moveToNext()) {
                buffer.append("id: " + cur.getString(0)+ "\n");
                buffer.append("Name: " + cur.getString(1)+ "\n"); buffer.append("Quantity: " + cur.getString(2)+ "\n\n");
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
            builder.setCancelable(true); // a dialog box that can be closed builder.setTitle("All Employees"); builder.setMessage(buffer.toString());
            builder.show();
            Toast.makeText(MainActivity3.this, "Successful View", Toast.LENGTH_LONG).show();
        } });
    }
}