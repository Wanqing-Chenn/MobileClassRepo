package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    private Spinner movieSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Initialize Spinner
        movieSpinner = findViewById(R.id.movieSpinner);

        // Create a list of movie titles for the dropdown
        String[] movieTitles = {
                "Avengers",
                "Black Panther",
                "Spider-Man",
                "Inception",
                "Interstellar",
                "Titanic"
        };

        // Create an ArrayAdapter to display the movie titles in the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, movieTitles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter to the Spinner
        movieSpinner.setAdapter(adapter);
    }
}
