package com.example.newsapp;

public class NewsData {
    private String title;
    private String description;
    private String date;
    private String imageUrl;
    private String url;

    public NewsData(String title, String description, String date, String imageUrl, String url) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.imageUrl = imageUrl;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUrl() {
        return url;
    }
}
