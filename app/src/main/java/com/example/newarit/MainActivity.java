package com.example.newarit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class MainActivity extends AppCompatActivity {
    EditText Name_In,Country_In,Email_In;
    private static final String FILE_NAME = "data.csv";
    private String[] tips_arr = {"Hello/General greeting -> Jojolopa","Thank You -> Subha","Welcome -> lasakusa","Yes -> Kha","No ->Makhu", "Warm Wishes ->Bhintuna"
            ,"Have? -> Du?"} ;
    Button reg_bnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name_In = findViewById(R.id.Name_In);
        Country_In = findViewById(R.id.Country_In);
        Email_In = findViewById(R.id.Email_In);
        reg_bnt =  findViewById(R.id.reg_btn);
    }
    public void reg(View v){
        String name = Name_In.getText().toString();
        String country = Country_In.getText().toString();
        String email = Email_In.getText().toString().trim();
        FileOutputStream fos = null ;

            try {
                final EditText emailValidate = (EditText)findViewById(R.id.Email_In);
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(!name.equals("") && !country.equals("") && !email.equals("") && email.matches(emailPattern)) {
                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    fos.write(name.getBytes(StandardCharsets.UTF_8));
                    fos.write(country.getBytes(StandardCharsets.UTF_8));
                    fos.write(email.getBytes(StandardCharsets.UTF_8));
                    Name_In.getText().clear();
                    Country_In.getText().clear();
                    Email_In.getText().clear();
                    setContentView(R.layout.activity_new);
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    int min=0;
                    int max = tips_arr.length;
                    int rnum = (int)Math.floor(Math.random()*(max-min+1)+min);
                    tip_msg(tips_arr[rnum]);

                }else {
                    Toast.makeText(getApplicationContext(),"Enter a Valid Details",Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

    private void tip_msg(String message){
        AlertDialog dig = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Tip of the Day")
                .setMessage(message)
                .setNegativeButton("OK", (dialogInterface, i) -> {
                    Intent act = new Intent(getApplicationContext(), NewActivity.class);
                    startActivity(act);
                }).create();
        dig.show();
    }
}