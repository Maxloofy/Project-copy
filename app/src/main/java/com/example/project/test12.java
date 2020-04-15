package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class test12 extends AppCompatActivity {

    Button b, b1, b2, b3, b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test12);


        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(test12.this, Main5Activity.class);
                startActivity(i);
            }
        });



        b = findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(test12.this, Main5Activity.class);
                startActivity(i);
            }
        });

        b2 = findViewById(R.id.b2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(test12.this, Main5Activity.class);
                startActivity(i);
            }
        });

        b3 = findViewById(R.id.b3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(test12.this, Main5Activity.class);
                startActivity(i);
            }
        });



        b4 = findViewById(R.id.b4);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(test12.this, Main5Activity.class);
                startActivity(i);
            }
        });

    }
}
