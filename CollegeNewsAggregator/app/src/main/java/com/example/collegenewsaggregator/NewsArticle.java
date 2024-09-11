package com.example.collegenewsaggregator;

public class NewsArticle {
    private final long id;
    private final String title;
    private final String content;
    private final String author;
    private final String date;

    public NewsArticle(long id, String title, String content, String author, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }
}

