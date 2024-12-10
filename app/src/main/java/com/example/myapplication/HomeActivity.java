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
        // Setup data
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
        Button profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }

    private void setupData() {
        // Create trending movies list
        List<Movie> trendingMovies = new ArrayList<>();
        trendingMovies.add(new Movie("Avengers", "Action/Sci-Fi", 4.5f, R.drawable.img_movie_avengers));
        trendingMovies.add(new Movie("Black Panther", "Action/Adventure", 4.3f, R.drawable.img_movie_blackpanther));
        trendingMovies.add(new Movie("Spider-Man", "Action/Adventure", 4.4f, R.drawable.img_movie_spiderman));

        // Create new releases list
        List<Movie> newReleases = new ArrayList<>();
        newReleases.add(new Movie("Interstellar", "Sci-Fi/Adventure", 4.8f, R.drawable.img_movie_interstellar));
        newReleases.add(new Movie("Inception", "Sci-Fi/Action", 4.7f, R.drawable.img_movie_inception));
        newReleases.add(new Movie("Titanic", "Romance/Drama", 4.6f, R.drawable.img_movie_titanic));

        // Set adapters
        MovieAdapter trendingAdapter = new MovieAdapter(trendingMovies);
        MovieAdapter newReleasesAdapter = new MovieAdapter(newReleases);

        recyclerViewTrending.setAdapter(trendingAdapter);
        recyclerViewNewReleases.setAdapter(newReleasesAdapter);

        // Set welcome message
        userNameText.setText("Welcome back, User");
    }
}