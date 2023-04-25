package com.example.resumemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class resumeTemplateOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_template_one);
        getSupportActionBar().hide();
    }
}