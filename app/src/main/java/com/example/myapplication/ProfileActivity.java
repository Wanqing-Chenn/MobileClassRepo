package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMovies;
    private RecyclerView recyclerViewReviews;
    private MovieAdapter movieAdapter;
    private ReviewAdapter reviewAdapter;
    private List<Movie> userMovies = new ArrayList<>();
    private List<Review> reviewList = new ArrayList<>();
    private Spinner movieSpinner;
    private EditText reviewText;
    private RatingBar ratingBar;
    private Button addMovieButton, submitReviewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        recyclerViewMovies = findViewById(R.id.recyclerViewMovies);
        recyclerViewReviews = findViewById(R.id.recyclerViewReviews);
        movieSpinner = findViewById(R.id.movieSpinner);
        reviewText = findViewById(R.id.editTextReview);
        ratingBar = findViewById(R.id.ratingBar);
        addMovieButton = findViewById(R.id.addMovieButton);
        submitReviewButton = findViewById(R.id.submitReviewButton);

        // Setup RecyclerViews
        recyclerViewMovies.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewReviews.setLayoutManager(new LinearLayoutManager(this));

        // Adapters for movies and reviews
        movieAdapter = new MovieAdapter(userMovies);
        reviewAdapter = new ReviewAdapter(reviewList);

        recyclerViewMovies.setAdapter(movieAdapter);
        recyclerViewReviews.setAdapter(reviewAdapter);

        // Sample movies
        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie("Avengers", "Action", 4.5f, R.drawable.img_movie_avengers, "Superheroes unite to save the world."));
        allMovies.add(new Movie("Titanic", "Romance", 4.8f, R.drawable.img_movie_titanic, "A love story set aboard the ill-fated Titanic."));
        allMovies.add(new Movie("Inception", "Sci-Fi", 4.7f, R.drawable.img_movie_inception, "A thief who enters the dreams of others is given a chance to have his criminal record erased."));
        allMovies.add(new Movie("Spider-Man", "Action", 4.9f, R.drawable.img_movie_spiderman, "A teenager gains superpowers and learns responsibility."));
        allMovies.add(new Movie("Black Panther", "Action", 4.8f, R.drawable.img_movie_blackpanther, "A young king must step into his legacy."));
        allMovies.add(new Movie("Interstellar", "Sci-Fi", 4.6f, R.drawable.img_movie_interstellar, "A group of explorers venture into a wormhole in search of a new home for humanity."));

        // Setup spinner with movie titles
        List<String> movieTitles = new ArrayList<>();
        for (Movie movie : allMovies) {
            movieTitles.add(movie.getTitle());
        }

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, movieTitles);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        movieSpinner.setAdapter(spinnerAdapter);

        // Add movie button functionality
        addMovieButton.setOnClickListener(v -> {
            int selectedPosition = movieSpinner.getSelectedItemPosition();
            Movie selectedMovie = allMovies.get(selectedPosition);
            if (!userMovies.contains(selectedMovie)) {
                userMovies.add(selectedMovie);
                movieAdapter.notifyDataSetChanged();
                Toast.makeText(this, selectedMovie.getTitle() + " added to your movies!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Movie already in your list!", Toast.LENGTH_SHORT).show();
            }
        });

        // Submit review button functionality
        submitReviewButton.setOnClickListener(v -> {
            String reviewContent = reviewText.getText().toString().trim();
            float rating = ratingBar.getRating();

            if (!reviewContent.isEmpty()) {
                // Add new review (uncorrelated with selected movie)
                reviewList.add(new Review(reviewContent, rating));
                reviewAdapter.notifyDataSetChanged();

                // Reset review text and rating bar
                reviewText.setText("");
                ratingBar.setRating(0);

                Toast.makeText(this, "Review added!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please write a review!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
