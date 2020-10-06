package com.app.testingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.spark.submitbutton.SubmitButton;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    SubmitButton submitButton;
    ProgressDialog progressDialog;

    //Declare an instance of FirebaseAuth
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Acrion Bar

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("LoginActivity");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Progress Dialog
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Registering User  .......");

        //Layout Button Setting
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.edit_username);
        password=findViewById(R.id.edit_password);
        submitButton=findViewById(R.id.submit);

        //Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=username.getText().toString().trim();
                String pass=password.getText().toString().trim();

                if(!Patterns.EMAIL_ADDRESS.matcher(user).matches())
                {
                    username.setError("Invalid Email");
                    username.setFocusable(true);
                }
                else if (password.length()<8)
                {
                    password.setError("Invalid Password");
                }
                else{
                    registerUser(user,pass);

                }

            }
        });
    }

    private void registerUser(String user, String pass) {
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(user, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            progressDialog.dismiss();
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(LoginActivity.this, "Registered Successful."+user.getEmail(),Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,ProfileActivity.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}