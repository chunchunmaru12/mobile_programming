package com.example.chaptersix;

public class Movie {
    private String title;
    private String genre;
    private int year;
    private int image;

    public Movie(String title, String genre, int year, int image) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.image = image;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
    public int getImage() { return image; }
}
