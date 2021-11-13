package com.ax.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView viewInputUsername;
    TextView viewInputPassword;
    Button viewSubmitButton;
    public static String username = "admin";
    public static String password = "User123!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewInputUsername = findViewById(R.id.inputUsername);
        viewInputPassword = findViewById(R.id.inputPassword);
        viewSubmitButton = findViewById(R.id.submitButton);
        viewSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = viewInputUsername.getText().toString();
                String password = viewInputPassword.getText().toString();
                if((!MainActivity.username.equals(username)) && (!MainActivity.password.equals(password))){
                    Toast.makeText(MainActivity.this, "Username and password is Wrong", Toast.LENGTH_SHORT).show();
                }else if(!MainActivity.password.equals(password)){
                    Toast.makeText(MainActivity.this, "Password is wrong", Toast.LENGTH_SHORT).show();
                }else if(!MainActivity.username.equals(username)){
                    Toast.makeText(MainActivity.this, "Username is wrong", Toast.LENGTH_SHORT).show();
                }else{
                    openMain2();
                }
                //openMain2();
            }
        });
    }

    public void openMain2(){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}