package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView profileUserNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        profileUserNameText = findViewById(R.id.textViewProfileUserName);

        // Load user data
        loadUserData();
    }

    private void loadUserData() {
        // Retrieve username from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "Guest");

        // Set the username to the TextView
        profileUserNameText.setText("Welcome, " + username + "!");
    }
}