package com.example.myapplication;

public class Movie {
    private String title;
    private String genre;
    private float rating;
    private int imageResourceId;

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
