package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private List<Movie> myMoviesList;
    private Spinner movieSpinner;
    private TextView selectedMovieText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize the RecyclerView and Spinner
        recyclerView = findViewById(R.id.myMoviesRecyclerView); // RecyclerView to show selected movies
        movieSpinner = findViewById(R.id.movieSpinner); // Spinner to select a movie
        selectedMovieText = findViewById(R.id.selectedMovieText); // TextView to show the selected movie title

        // Initialize the list and adapter for RecyclerView
        myMoviesList = new ArrayList<>();
        movieAdapter = new MovieAdapter(myMoviesList); // Reuse the existing MovieAdapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(movieAdapter);

        // Populate the spinner with all available movies
        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie("Avengers", "Action/Sci-Fi", 4.5f, R.drawable.img_movie_avengers));
        allMovies.add(new Movie("Black Panther", "Action/Adventure", 4.3f, R.drawable.img_movie_blackpanther));
        allMovies.add(new Movie("Spider-Man", "Action/Adventure", 4.4f, R.drawable.img_movie_spiderman));
        allMovies.add(new Movie("Interstellar", "Sci-Fi/Adventure", 4.8f, R.drawable.img_movie_interstellar));
        allMovies.add(new Movie("Inception", "Sci-Fi/Action", 4.7f, R.drawable.img_movie_inception));
        allMovies.add(new Movie("Titanic", "Romance/Drama", 4.6f, R.drawable.img_movie_titanic));

        // Create an ArrayAdapter for the Spinner using movie titles
        ArrayAdapter<Movie> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, allMovies);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        movieSpinner.setAdapter(spinnerAdapter);

        // Add listener to handle movie selection from Spinner
        movieSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Movie selectedMovie = allMovies.get(position);

                // Add the selected movie to the "My Movies" list
                myMoviesList.add(selectedMovie);
                movieAdapter.notifyDataSetChanged(); // Notify adapter to update RecyclerView

                // Update the selected movie title
                selectedMovieText.setText("Selected Movie: " + selectedMovie.getTitle());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle case when no movie is selected (optional)
            }
        });
    }
}
