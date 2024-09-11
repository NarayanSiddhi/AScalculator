package com.example.collegenewsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<NewsArticle> newsList = databaseHelper.getAllNews();
        newsAdapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(newsAdapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewsArticle();
            }
        });

        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNewsArticle();
            }
        });
    }

    private void addNewsArticle() {
        // TODO: Implement adding a news article to the database
        // Retrieve data from UI elements and create a NewsArticle object
        // Call databaseHelper.addNewsArticle(newsArticle) to add it to the database
        // Refresh the news list and notify the adapter

        // Example:
        NewsArticle newsArticle = new NewsArticle("Title", "Description");
        databaseHelper.addNewsArticle(newsArticle);

        List<NewsArticle> updatedNewsList = databaseHelper.getAllNews();
        newsAdapter.updateNewsList(updatedNewsList);
    }

    private void deleteNewsArticle() {
        // TODO: Implement deleting a news article from the database
        // Retrieve the selected news article from the adapter
        // Call databaseHelper.deleteNewsArticle(newsArticle) to delete it from the database
        // Refresh the news list and notify the adapter

        // Example:
        NewsArticle selectedNewsArticle = newsAdapter.getSelectedNewsArticle();
        if (selectedNewsArticle != null) {
            databaseHelper.deleteNewsArticle(selectedNewsArticle);

            List<NewsArticle> updatedNewsList = databaseHelper.getAllNews();
            newsAdapter.updateNewsList(updatedNewsList);
        }
    }
}
