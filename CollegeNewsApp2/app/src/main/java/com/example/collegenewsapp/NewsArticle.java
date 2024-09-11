package com.example.collegenewsapp;

public class NewsArticle {
    private int id;
    private String title;
    private String description;
    private String author;
    private String date;

    public NewsArticle(int id, String title, String description, String author, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }
}
