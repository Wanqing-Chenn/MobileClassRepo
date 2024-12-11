package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerViewTrending;
    private RecyclerView recyclerViewNewReleases;
    private TextView userNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize views
        initViews();
        // Setup data for RecyclerViews
        setupData();
    }

    private void initViews() {
        recyclerViewTrending = findViewById(R.id.recyclerViewTrending);
        recyclerViewNewReleases = findViewById(R.id.recyclerViewNewReleases);
        userNameText = findViewById(R.id.textViewUserName);

        // Set RecyclerView layout managers
        recyclerViewTrending.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );
        recyclerViewNewReleases.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        // Set up profile button
        Button profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(v -> {
            // Navigate to ProfileActivity when clicked
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }

    private void setupData() {
        // Create trending movies list
        List<Movie> trendingMovies = new ArrayList<>();
        trendingMovies.add(new Movie("Avengers", "Action/Sci-Fi", 4.5f, R.drawable.img_movie_avengers, "The Avengers assemble to save Earth."));
        trendingMovies.add(new Movie("Black Panther", "Action/Adventure", 4.3f, R.drawable.img_movie_blackpanther, "Black Panther must fight to protect his kingdom."));
        trendingMovies.add(new Movie("Spider-Man", "Action/Adventure", 4.4f, R.drawable.img_movie_spiderman, "Peter Parker balances his life as a student and superhero."));

        // Create new releases list
        List<Movie> newReleases = new ArrayList<>();
        newReleases.add(new Movie("Interstellar", "Sci-Fi/Adventure", 4.8f, R.drawable.img_movie_interstellar, "Astronauts travel through a wormhole in search of a new home for humanity."));
        newReleases.add(new Movie("Inception", "Sci-Fi/Action", 4.7f, R.drawable.img_movie_inception, "A thief who enters the dreams of others to steal secrets embarks on his most difficult mission."));
        newReleases.add(new Movie("Titanic", "Romance/Drama", 4.6f, R.drawable.img_movie_titanic, "The doomed love affair aboard the RMS Titanic between Jack and Rose."));

        // Set up the RecyclerView adapters
        MovieAdapter trendingAdapter = new MovieAdapter(trendingMovies);
        MovieAdapter newReleasesAdapter = new MovieAdapter(newReleases);

        recyclerViewTrending.setAdapter(trendingAdapter);
        recyclerViewNewReleases.setAdapter(newReleasesAdapter);

        // Set welcome message
        userNameText.setText("Welcome back, User");
    }

}
