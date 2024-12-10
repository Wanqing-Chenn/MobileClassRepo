package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movies;
    private Map<String, MovieReview> movieReviews; // Store reviews for user input

    public MovieAdapter(List<Movie> movies, Map<String, MovieReview> movieReviews) {
        this.movies = movies;
        this.movieReviews = movieReviews;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView titleText;
        TextView genreText;
        TextView ratingText;
        TextView reviewText; // TextView to display the review
        EditText reviewEditText; // EditText for user input

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            titleText = itemView.findViewById(R.id.textViewTitle);
            genreText = itemView.findViewById(R.id.textViewGenre);
            ratingText = itemView.findViewById(R.id.textViewRating);
            reviewText = itemView.findViewById(R.id.textViewReview);
            reviewEditText = itemView.findViewById(R.id.editTextReview); // EditText for review
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.imageView.setImageResource(movie.getImageResourceId());
        holder.titleText.setText(movie.getTitle());
        holder.genreText.setText(movie.getGenre());
        holder.ratingText.setText("★ " + movie.getRating());

        // For the User page, display the review or prompt to add a review
        MovieReview review = movieReviews.get(movie.getTitle());
        if (review != null) {
            holder.reviewText.setText(review.getReviewText()); // Display review text
        }

        // For User input, show the EditText for review and allow editing
        holder.reviewEditText.setText(""); // Clear EditText initially
        holder.reviewEditText.setVisibility(View.VISIBLE); // Show EditText on User page
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
