package com.example.myapplication;

public class Movie {
    private final String title;
    private final String genre;
    private final float rating;
    private final int imageResourceId;
    private final String description;

    public Movie(String title, String genre, float rating, int imageResourceId, String description) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.imageResourceId = imageResourceId;
        this.description = description;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public float getRating() {
        return rating;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }
}
