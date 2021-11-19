package com.ax.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ax.projectapp.src.Configuration;
import com.ax.projectapp.src.Controls;

public class NewPasswordActivity extends AppCompatActivity {
    TextView etPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        btnSubmit = findViewById(R.id.new_password_activity_btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPassword = findViewById(R.id.new_password_activity_etPassword);
                String inputPass = etPassword.getText().toString();
                if(inputPass.length() < 6){
                    Toast.makeText(NewPasswordActivity.this, R.string.new_password_activity_password_warning_6characters, Toast.LENGTH_SHORT).show();
                }else if(!Controls.isAnyUpperLetterInIt(inputPass)){
                    Toast.makeText(NewPasswordActivity.this, R.string.new_password_activity_password_warning_uppercase, Toast.LENGTH_SHORT).show();
                }else if(!Controls.isAnyPunctuationInIt(inputPass)){
                    Toast.makeText(NewPasswordActivity.this, R.string.new_password_activity_password_warning_special_characters, Toast.LENGTH_SHORT).show();
                }else{
                    Configuration.password = inputPass;
                    openLoginActivity();
                }
            }
        });
    }


    public void openLoginActivity(){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}