package com.project.olympos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Article extends AppCompatActivity {

    private TextView tvResume, tvMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        tvResume = findViewById(R.id.tvResume);
        tvMoreInfo = findViewById(R.id.tvMoreInfo);
    }
}