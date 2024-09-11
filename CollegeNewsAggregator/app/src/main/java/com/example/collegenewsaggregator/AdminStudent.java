package com.example.collegenewsaggregator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminStudent extends AppCompatActivity {

    Button adminlogin,studentlogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_student);

        adminlogin=findViewById(R.id.admin);
        studentlogin=findViewById(R.id.student);

        adminlogin.setOnClickListener(view -> {
            Intent intent = new Intent(AdminStudent.this, MainActivity.class);
            startActivity(intent);
        });

        studentlogin.setOnClickListener(view -> {
            Intent intent = new Intent(AdminStudent.this, NewsFeedActivity.class);
            startActivity(intent);
        });
    }
}
