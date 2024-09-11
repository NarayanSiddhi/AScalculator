package com.example.collegenewsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<NewsArticle> newsList;
    private NewsArticle selectedNewsArticle;

    public NewsAdapter(List<NewsArticle> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsArticle newsArticle = newsList.get(position);
        holder.titleTextView.setText(newsArticle.getTitle());
        holder.descriptionTextView.setText(newsArticle.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedNewsArticle = newsArticle;
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public NewsArticle getSelectedNewsArticle() {
        return selectedNewsArticle;
    }

    public void updateNewsList(List<NewsArticle> updatedNewsList) {
        newsList = updatedNewsList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView descriptionTextView;

        public ViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.titleTextView);
            descriptionTextView = view.findViewById(R.id.descriptionTextView);
        }
    }
}
