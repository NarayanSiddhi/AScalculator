package com.example.collegenewsapp;

import android.content.Context;

import java.util.List;

public class NewsArticleRepository {
    private NewsArticleDatabaseHelper databaseHelper;

    public NewsArticleRepository(Context context) {
        databaseHelper = new NewsArticleDatabaseHelper(context);
    }

    public void addNewsArticle(NewsArticle newsArticle) {
        databaseHelper.addNewsArticle(newsArticle);
    }

    public void updateNewsArticle(NewsArticle newsArticle) {
        databaseHelper.updateNewsArticle(newsArticle);
    }

    public void deleteNewsArticle(NewsArticle newsArticle) {
        databaseHelper.deleteNewsArticle(newsArticle);
    }

    public List<NewsArticle> getAllNewsArticles() {
        return databaseHelper.getAllNewsArticles();
    }
}
