package com.example.collegenewsapp;
public class NewsArticle {
    private int id;
    private String title;
    private String description;

    public NewsArticle(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
