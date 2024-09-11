package com.example.collegenewsapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NewsArticleViewModel extends AndroidViewModel {
    private NewsArticleRepository repository;
    private LiveData<List<NewsArticle>> allNewsArticles;

    public NewsArticleViewModel(@NonNull Application application) {
        super(application);
        repository = new NewsArticleRepository(application);
        allNewsArticles = (LiveData<List<NewsArticle>>) repository.getAllNewsArticles();
    }

    public void addNewsArticle(NewsArticle newsArticle) {
        repository.addNewsArticle(newsArticle);
    }

    public void updateNewsArticle(NewsArticle newsArticle) {
        repository.updateNewsArticle(newsArticle);
    }

    public void deleteNewsArticle(NewsArticle newsArticle) {
        repository.deleteNewsArticle(newsArticle);
    }

    public LiveData<List<NewsArticle>> getAllNewsArticles() {
        return allNewsArticles;
    }
}
