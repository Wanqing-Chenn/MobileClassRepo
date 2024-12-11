package com.example.myapplication;

public class Review {
    private final String reviewText;
    private final float rating;

    public Review(String reviewText, float rating) {
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public float getRating() {
        return rating;
    }
}
