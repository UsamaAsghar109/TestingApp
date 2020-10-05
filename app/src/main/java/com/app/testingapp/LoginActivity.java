package com.app.testingapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.spark.submitbutton.SubmitButton;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    SubmitButton submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Acrion Bar

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("LoginActivity");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        //Layout Button Setting
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.edit_username);
        password=findViewById(R.id.edit_password);
        submitButton=findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username==null)
                {
                    Toast.makeText(LoginActivity.this, "Username is empty", Toast.LENGTH_SHORT).show();
                }
                else if (password==null)
                {
                    Toast.makeText(LoginActivity.this, "Password is empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}