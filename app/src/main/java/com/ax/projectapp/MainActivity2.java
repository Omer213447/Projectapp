package com.ax.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {
    TextView viewInputNewPass;
    Button viewSubmitPassButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewSubmitPassButton = findViewById(R.id.submitPassButton);
        viewSubmitPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewInputNewPass = findViewById(R.id.inputNewPass);
                String inputPass = viewInputNewPass.getText().toString();
                if(inputPass.length() < 6){
                    Toast.makeText(MainActivity2.this, "Password must contain atleast 6 characters", Toast.LENGTH_SHORT).show();
                }else if(!isAnyUpperLetterInIt(inputPass)){
                    Toast.makeText(MainActivity2.this, "Password must contain uppercase letter(s)", Toast.LENGTH_SHORT).show();
                }else if(!isAnyPunctuationInIt(inputPass)){
                    Toast.makeText(MainActivity2.this, "Password must contain some special characters like . - ! ; , etc.", Toast.LENGTH_SHORT).show();
                }else{
                    MainActivity.password = inputPass;
                    openMain();
                }
            }
        });
    }
    //This function will look if there is upper letter in the string, if there is output 1(True), if not output 0(false)
    private boolean isAnyUpperLetterInIt(String looked){
        return Pattern.matches(".*[A-Z].*", looked);
    }

    private boolean isAnyPunctuationInIt(String looked){
        return Pattern.matches(".*[!\"#$%&'()*+,-.\\/:;<=>?@\\[\\]^_`\\{|\\}~].*", looked);
    }

    public void openMain(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}