package com.example.newarit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText Name,Country,Email;
    Button bnt;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Name = (EditText) findViewById(R.id.Name_In);
            Country = (EditText) findViewById(R.id.Country_In);
            Email = (EditText) findViewById(R.id.Email_In);
            bnt = (Button) findViewById(R.id.reg_btn);
            bnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = Name.getText().toString();
                    String email = Email.getText().toString();
                    String country = Country.getText().toString();
                    if (!name.equals("") && !email.equals("") && !country.equals("") && ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
                    {
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);

                    }
                    try {
                        @SuppressLint("SdCardPath") File file = new File("/sdcard/NewariT/");
                        file.mkdirs();
                        @SuppressLint("SdCardPath") String csv = "/sdcard/NewariT/data.csv";
                        CSVWriter csvWriter = new CSVWriter(new FileWriter(csv, true));
                        String[] row = new String[]{name,email,country};
                        csvWriter.writeNext(row);
                        csvWriter.close();
                        Toast.makeText(MainActivity.this,"Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),NewActivity.class);
                        startActivity(intent);
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this,"Failed", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
}