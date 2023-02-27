package com.example.resumemaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {

    ImageView imgSignupGif;
    TextInputLayout tilSignupEmail, tilSignupFullName, tilSignupNumber;
    Button btnSignupContinue;
    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        imgSignupGif = findViewById(R.id.imgSignupGif);
        tilSignupEmail = findViewById(R.id.tilLoginEmail);
        tilSignupFullName = findViewById(R.id.tilEnterPassword);
        tilSignupNumber = findViewById(R.id.tilForgotPasswordNumber);
        txtLogin = findViewById(R.id.txtLogin);
        btnSignupContinue = findViewById(R.id.btnSignupContinue);

        //Load GIF Image
//        Glide.with(this).load(R.drawable.signup_gif).into(imgSignupGif);

        //Continue Button Code
        btnSignupContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  email = tilSignupEmail.getEditText().getText().toString().trim();
                String fullName = tilSignupFullName.getEditText().getText().toString().trim();
                String number = tilSignupNumber.getEditText().getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(email.equals("")){
                    tilSignupEmail.setError("Enter your Email");
                } else if (!email.matches(emailPattern)) {
                    tilSignupEmail.setError("Invalid email address");
                } else if (fullName.equals("")) {
                    tilSignupFullName.setError("Enter your Full Name");
                } else if (number.equals("")) {
                    tilSignupNumber.setError("Enter Mobile Number");
                }else{
                    Toast.makeText(SignupActivity.this, ""+email+" hi "+fullName+ "  "+number, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Go to Login Page
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGotoLogin = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intentGotoLogin);
            }
        });

    }
}