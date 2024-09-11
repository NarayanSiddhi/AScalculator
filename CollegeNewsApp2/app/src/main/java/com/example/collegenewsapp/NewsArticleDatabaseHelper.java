package com.example.collegenewsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class NewsArticleDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "news_articles.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "news_article";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_DATE = "date";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TITLE + " TEXT, " +
            COLUMN_DESCRIPTION + " TEXT, " +
            COLUMN_AUTHOR + " TEXT, " +
            COLUMN_DATE + " TEXT)";

    public NewsArticleDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addNewsArticle(NewsArticle newsArticle) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, newsArticle.getTitle());
        values.put(COLUMN_DESCRIPTION, newsArticle.getDescription());
        values.put(COLUMN_AUTHOR, newsArticle.getAuthor());
        values.put(COLUMN_DATE, newsArticle.getDate());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateNewsArticle(NewsArticle newsArticle) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, newsArticle.getTitle());
        values.put(COLUMN_DESCRIPTION, newsArticle.getDescription());
        values.put(COLUMN_AUTHOR, newsArticle.getAuthor());
        values.put(COLUMN_DATE, newsArticle.getDate());

        db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(newsArticle.getId())});
        db.close();
    }

    public void deleteNewsArticle(NewsArticle newsArticle) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[]{String.valueOf(newsArticle.getId())});
        db.close();
    }

    public List<NewsArticle> getAllNewsArticles() {
        List<NewsArticle> newsArticles = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION));
                String author = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AUTHOR));
                String date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE));

                NewsArticle newsArticle = new NewsArticle(id, title, description, author, date);
                newsArticles.add(newsArticle);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return newsArticles;
    }

}
