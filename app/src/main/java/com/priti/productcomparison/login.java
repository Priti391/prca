package com.priti.productcomparison;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class login extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private EditText usernameEditText;
    private Button loginButton;
    private TextView registerTextView;
    private Button SignInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        emailEditText = findViewById(R.id.emailEditText);
        loginButton = findViewById(R.id.loginButton);
        registerTextView = findViewById(R.id.registerTextView);
        SignInButton = findViewById(R.id.SignInButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("Email is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Password is required");
            return;
        }

        // Retrieve saved user data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        String savedEmail = sharedPreferences.getString("email", "");
        String savedPassword = sharedPreferences.getString("password", "");

        if (email.equals(savedEmail) && password.equals(savedPassword)) {
            // Login successful
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            // Navigate to main activity or any other destination
            startActivity(new Intent(login.this, MainActivity.class));
            finish(); // Finish current activity to prevent going back to login
        } else {
            // Invalid credentials
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }


        Intent intent = new Intent(login.this, SearchActivity.class);
        startActivity(intent);
        finish(); // Optional, to close the login activity and prevent the user from navigating back
    }
}