package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Main6Activity extends AppCompatActivity {
    private  static int SPLASH_TIME_OUT = 3400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Main6Activity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
