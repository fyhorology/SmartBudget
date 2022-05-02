package com.example.moneyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    //Defining firebase, clickables, and input texts(email / password)
    private FirebaseAuth auth;
    private Button btnLogin;
    private Button btnSignUp;
    private EditText editTextEmail;
    private EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Assigning clickbales via ID from xml, and password/email format via ID from xml
        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance();
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignup);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextTextPassword);

        //Onclick button login, check for input in email/password field, proceed with signin function if present"
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextEmail.getText().toString().isEmpty() || !editTextPassword.getText().toString().isEmpty()) {
                    signInUser(editTextEmail.getText().toString(), editTextPassword.getText().toString());

                } else {
                    Toast.makeText(getApplicationContext(), "Input required", Toast.LENGTH_LONG).show();
                }
            }
        });

        //OnClick button SignUp, brings to the SignUp form page. (SignUpActivity.java)
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    // to exit app when clicking back button
    @Override
    public void onBackPressed()
    {
        finish();
    }

    //Sign in function, if credentials match process is successful, hence go to MainActivity.java, else popout error
    private void signInUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error !! " + task.getException(), Toast.LENGTH_LONG).show();
                    }

                });
    }
}