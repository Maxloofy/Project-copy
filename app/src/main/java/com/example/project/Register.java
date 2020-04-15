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

public class Register extends AppCompatActivity {



    EditText mFullname, mEmail, mPassword, mPhone, mConfPassword;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullname = findViewById(R.id.mFullname);
        mEmail = findViewById(R.id.mEmail);
        mPassword = findViewById(R.id.mPassword);
        mPhone = findViewById(R.id.mPhone);
        mRegisterBtn = findViewById(R.id.mRegisterBtn);
        mLoginBtn = findViewById(R.id.mLoginBtn);
        mConfPassword = findViewById(R.id.mConfPassword);


        fAuth = FirebaseAuth.getInstance();




        if(fAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),Main2Activity.class));
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("البريد الالكتروني مطاوب");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("كلمة المرور مطلوبة");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("Characters must be more than 6 characters");
                    return;
                }



                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Main2Activity.class));


                        }else{
                            Toast.makeText(Register.this, "ERROR" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();



                        }




                    }
                });

            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);

            }
        });


    }
}
