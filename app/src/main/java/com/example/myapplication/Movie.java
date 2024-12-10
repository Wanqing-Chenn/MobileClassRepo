package com.example.myapplication;

public class Movie {
    private final String title;
    private final String genre;
    private final float rating;
    private final int imageResourceId;

    public Movie(String title, String genre, float rating, int imageResourceId) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.imageResourceId = imageResourceId;
    }

    // Getters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public float getRating() { return rating; }
    public int getImageResourceId() { return imageResourceId; }
}
