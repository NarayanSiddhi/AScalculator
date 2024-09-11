package com.example.collegenewsaggregator;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private List<Article> articleList;
    private DatabaseHelper databaseHelper;
    private EditText etTitle, etContent, etAuthor, etDate;
    private Button btnAddArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        etTitle = findViewById(R.id.etTitle);
        etContent = findViewById(R.id.etContent);
        etAuthor = findViewById(R.id.etAuthor);
        etDate = findViewById(R.id.etDate);
        btnAddArticle = findViewById(R.id.btnAddArticle);

        databaseHelper = new DatabaseHelper(this);
        articleList = new ArrayList<>();

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArticleAdapter(articleList);
        recyclerView.setAdapter(adapter);
        // Retrieve articles from the database and update the RecyclerView
        retrieveArticles();

        btnAddArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input from EditText fields
                String title = etTitle.getText().toString().trim();
                String content = etContent.getText().toString().trim();
                String author = etAuthor.getText().toString().trim();
                String date = etDate.getText().toString().trim();

                // Create new article object
                Article article = new Article(title, content, author, date);

                // Add the article to the database
                addArticle(article);

                // Clear EditText fields
                etTitle.setText("");
                etContent.setText("");
                etAuthor.setText("");
                etDate.setText("");

                // Retrieve articles from the database and update the RecyclerView
                retrieveArticles();
            }
        });
    }


    private void retrieveArticles() {
        articleList.clear();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TITLE));
                @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CONTENT));
                @SuppressLint("Range") String author = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_AUTHOR));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE));

                Article article = new Article();
                article.setId(id);
                article.setTitle(title);
                article.setContent(content);
                article.setAuthor(author);
                article.setDate(date);

                articleList.add(article);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        adapter.notifyDataSetChanged();
    }

    private void addArticle(Article article) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TITLE, article.getTitle());
        values.put(DatabaseHelper.COLUMN_CONTENT, article.getContent());
        values.put(DatabaseHelper.COLUMN_AUTHOR, article.getAuthor());
        values.put(DatabaseHelper.COLUMN_DATE, article.getDate());
        db.insert(DatabaseHelper.TABLE_NAME, null, values);
        db.close();
    }
}
