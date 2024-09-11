package com.example.collegenewsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NewsArticleViewModel newsArticleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView newsArticleRecyclerView = findViewById(R.id.newsArticleRecyclerView);
        newsArticleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsArticleRecyclerView.setHasFixedSize(true);

        final NewsArticleAdapter adapter = new NewsArticleAdapter();
        newsArticleRecyclerView.setAdapter(adapter);

        newsArticleViewModel = new ViewModelProvider(this).get(NewsArticleViewModel.class);
        newsArticleViewModel.getAllNewsArticles().observe(this, new Observer<List<NewsArticle>>() {
            @Override
            public void onChanged(List<NewsArticle> newsArticles) {
                adapter.setNewsArticles(newsArticles);
            }
        });

        Button addNewsArticleButton = findViewById(R.id.addNewsArticleButton);
        addNewsArticleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement code to add a new news article to the database
            }
        });

        Button updateNewsArticleButton = findViewById(R.id.updateNewsArticleButton);
        updateNewsArticleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement code to update a news article in the database
            }
        });

        Button deleteNewsArticleButton = findViewById(R.id.deleteNewsArticleButton);
        deleteNewsArticleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement code to delete a news article from the database
            }
        });
    }
}