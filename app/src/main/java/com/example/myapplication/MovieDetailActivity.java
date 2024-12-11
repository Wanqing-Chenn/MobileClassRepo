package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailActivity extends AppCompatActivity {
    private TextView movieTitle, movieDescription, movieGenre;
    private RatingBar movieRating;
    private ImageView movieImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        // Initialize views
        movieTitle = findViewById(R.id.textViewMovieTitle);
        movieDescription = findViewById(R.id.textViewMovieDescription);
        movieGenre = findViewById(R.id.textViewMovieGenre);
        movieRating = findViewById(R.id.ratingBarMovieRating);
        movieImage = findViewById(R.id.imageViewMovieImage);

        // Retrieve movie data from intent
        String title = getIntent().getStringExtra("movieTitle");
        String description = getIntent().getStringExtra("movieDescription");
        String genre = getIntent().getStringExtra("movieGenre");
        float rating = getIntent().getFloatExtra("movieRating", 0);
        int imageResourceId = getIntent().getIntExtra("movieImage", 0);

        // Set data to views
        movieTitle.setText(title);
        movieDescription.setText(description);
        movieGenre.setText(genre);
        movieRating.setRating(rating);
        movieImage.setImageResource(imageResourceId);
    }
}
