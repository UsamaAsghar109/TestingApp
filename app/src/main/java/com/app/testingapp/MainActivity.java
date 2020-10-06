package com.app.testingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.spark.submitbutton.SubmitButton;

import java.util.Timer;


public class MainActivity extends AppCompatActivity {

    Timer timer;
    SubmitButton submitButton;
    Button loginbtn,registerbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        timer=new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//
//                    Intent intent=new Intent(MainActivity.this,LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            },3000);
        registerbtn=findViewById(R.id.register);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}