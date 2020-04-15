package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login1 extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    FirebaseAuth fAuth;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        TextView mCreateBtn = findViewById(R.id.mCreateBtn1);


        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login1.this, Register.class);
                startActivity(i);
            }
        });

        mEmail = findViewById(R.id.mEmail);
        mPassword = findViewById(R.id.mPassword);
        mLoginBtn = findViewById(R.id.mLoginBtn);
        fAuth = FirebaseAuth.getInstance();




        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("Characters must be more than 6 characters");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            Toast.makeText(login1.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Main2Activity.class));

                        }else{

                            Toast.makeText(login1.this, "ERROR" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });






    }
}
