package com.example.moneyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    //Defining firebase, input texts, and clickables
    EditText editTextEmail;
    EditText editTextPassword;
    Button btnSignUp;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();

        //Assigning input text and password, and clickables via ID from xml
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        btnSignUp = findViewById(R.id.btnSignup);

        //Onclick button SIgnup, check for input in Email and Password field, proceed to createUser function if present, else error popout "Input provided"
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editTextEmail.getText().toString().isEmpty() || !editTextPassword.getText().toString().isEmpty()) {
                    createUser(editTextEmail.getText().toString().trim(), editTextPassword.getText().toString().trim());

                }else{
                    Toast.makeText(getApplicationContext(),"Input provided",Toast.LENGTH_LONG).show();

                }
            }
        });


    }

    //createUser function via input email and password and create user in Firebase database, and proceed to direct user to MainActivity.java (to input their income)
    private void createUser(String email, String password) {
        auth.createUserWithEmailAndPassword(
                email,
                password
        )
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Log.d("TAG", "Sign up failed... " + task.getException());
                    }
                });
    }
}