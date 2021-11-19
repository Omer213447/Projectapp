package com.ax.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ax.projectapp.src.Configuration;

public class LoginActivity extends AppCompatActivity {
    TextView etUsername;
    TextView etPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.login_activity_etUsername);
        etPassword = findViewById(R.id.login_activity_etPassword);
        btnSubmit = findViewById(R.id.login_activity_btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if((!Configuration.username.equals(username)) && (!Configuration.password.equals(password))){
                    Toast.makeText(LoginActivity.this, R.string.login_activity_warning_username_password_wrong, Toast.LENGTH_SHORT).show();
                }else if(!Configuration.password.equals(password)){
                    Toast.makeText(LoginActivity.this, R.string.login_activity_warning_password_wrong, Toast.LENGTH_SHORT).show();
                }else if(!Configuration.username.equals(username)){
                    Toast.makeText(LoginActivity.this, R.string.login_activity_warning_username_wrong, Toast.LENGTH_SHORT).show();
                }else{
                    openNewPasswordActivity();
                }
            }
        });
    }

    public void openNewPasswordActivity(){
        Intent i = new Intent(this, NewPasswordActivity.class);
        startActivity(i);
    }
}