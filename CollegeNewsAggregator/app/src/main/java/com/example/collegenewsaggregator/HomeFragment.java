package com.example.collegenewsaggregator;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private NewsArticle newsArticle;

    public static HomeFragment newInstance(NewsArticle newsArticle) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putParcelable("newsArticle", (Parcelable) newsArticle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey("newsArticle")) {
            newsArticle = getArguments().getParcelable("newsArticle");
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.homefragment,container,false);
        TextView titleTextView = v.findViewById(R.id.titleTextView);
        TextView contentTextView = v.findViewById(R.id.contentTextView);
        TextView authorTextView = v.findViewById(R.id.authorTextView);
        TextView dateTextView = v.findViewById(R.id.dateTextView);

        if (newsArticle != null) {
            titleTextView.setText(newsArticle.getTitle());
            contentTextView.setText(newsArticle.getContent());
            authorTextView.setText(newsArticle.getAuthor());
            dateTextView.setText(newsArticle.getDate());
        }

        return v;
    }
}
