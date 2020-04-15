package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {


    EditText mEmail, mPassword;
    Button mLoginBtn;
    FirebaseAuth fAuth;
    TextView textView5;
    ProgressBar progressBar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        mEmail = findViewById(R.id.mEmail);
        mPassword = findViewById(R.id.mPassword);
        mLoginBtn = findViewById(R.id.mLoginBtn);
        fAuth = FirebaseAuth.getInstance();
        textView5 = findViewById(R.id.textView5);
        progressBar4 = findViewById(R.id.progressBar4);


        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(i3);
            }
        });





        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("البريد الالكتروني مطلوب ");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("كلمة المرور مطلوبة");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            Toast.makeText(MainActivity.this, "نجح تسجيل الدخول", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Main2Activity.class));

                        }else{

                            Toast.makeText(MainActivity.this, "ERROR" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                progressBar4.setVisibility(View.VISIBLE);


            }


        });



        TextView phone;

        phone = findViewById(R.id.phone);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent call = new Intent(Intent.ACTION_DIAL);
               call.setData(Uri.parse("tel:12345678"));
               startActivity(call);

            }
        });

















    }

    }

