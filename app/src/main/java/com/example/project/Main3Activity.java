package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mFullname, mEmail, mPassword, mPhone, mConfPassword;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userID;
    ProgressBar progressBar3;

    boolean isEmpty(EditText text) {
        String str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mFullname = findViewById(R.id.mFullname);
        mEmail = findViewById(R.id.mEmail);
        mPassword = findViewById(R.id.mPassword);
        mPhone = findViewById(R.id.mPhone);
        mRegisterBtn = findViewById(R.id.mRegisterBtn);
        mLoginBtn = findViewById(R.id.mLoginBtn);
        mConfPassword = findViewById(R.id.mConfPassword);
        progressBar3 = findViewById(R.id.progressBar3);


        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();




        if(fAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),Main2Activity.class));
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                final String fullname = mFullname.getText().toString().trim();
                final String phone = mPhone.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("البريد الالكتروني مطلوب");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("كلمة المرور مطلوبة");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("يجب ان تكون كلمة المرور اكثر من ٦ احرف");
                    return;



                }

                progressBar3.setVisibility(View.VISIBLE);



                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Main3Activity.this, "تم انشاء الحساب بنجاح", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName", fullname);
                            user.put("email", email);
                            user.put("phone", phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user profile is created for "+userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure:"+ e.toString());
                                }
                            });

                            startActivity(new Intent(getApplicationContext(),Main2Activity.class));


                        }else{
                            Toast.makeText(Main3Activity.this, "حصل خطأ في انشاء الحساب" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();



                        }




                    }
                });

            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(i);

            }
        });


    }
}

