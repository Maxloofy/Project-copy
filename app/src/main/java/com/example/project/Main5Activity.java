package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    RadioGroup radioGroup, radiogroup2;
    RadioButton radio1, radio2, radio3;
    RadioButton radioButton3, radioButton4,radioButton5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        radioGroup = findViewById(R.id.radio_group);
        radiogroup2 = findViewById(R.id.radiogroup2);

        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);





        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main5Activity.this, "لقد اخترت 50 دينار كويتي", Toast.LENGTH_SHORT).show();

            }
        });

        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main5Activity.this, "لقد اخترت 10 دنانير كويتي", Toast.LENGTH_SHORT).show();

            }
        });


        radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main5Activity.this, "لقد اخترت 20 دينار كويتي", Toast.LENGTH_SHORT).show();

            }
        });

        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main5Activity.this, "لقد اخترت Knet كطريقة الدفع", Toast.LENGTH_SHORT).show();

            }
        });

        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main5Activity.this, "لقد اخترت Credit Card كطريقة الدفع ", Toast.LENGTH_SHORT).show();

            }
        });

        radioButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main5Activity.this, "لقد اخترت Paypal كطريقة الدفع ", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
