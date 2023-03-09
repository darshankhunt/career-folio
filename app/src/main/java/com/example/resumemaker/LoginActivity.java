package com.example.resumemaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout tilEmail, tilPassword;
    private Button btnLogin;
    private TextView txtSignUP, txtForgetPassword;
    private ImageView imgLoginGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        imgLoginGif = findViewById(R.id.imgLoginGif);
        tilEmail = findViewById(R.id.tilLoginEmail);
        tilPassword = findViewById(R.id.tilEnterPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtSignUP = findViewById(R.id.txtSignUp);
        txtForgetPassword = findViewById(R.id.txtForgetPassword);

        //Load GIF Image
//        Glide.with(this).load(R.drawable.login_gif).into(imgLoginGif);

        //Login ButtonCode
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = tilEmail.getEditText().getText().toString().trim();
                String password = tilPassword.getEditText().getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(email.equals("")){
                    tilEmail.setError("Enter your Email");
                } else if (!email.matches(emailPattern)) {
                    tilEmail.setError("Invalid email address");
                } else if (password.equals("")) {
                    tilPassword.setError("Enter your Password");
                }
                Toast.makeText(LoginActivity.this, ""+email+" hi "+password, Toast.LENGTH_SHORT).show();
            }
        });

        //Forget Password Page Code
        txtForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTOForgetPassword = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(goTOForgetPassword);
            }
        });

        //Sign up Page Code
        txtSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTOSignUp = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(goTOSignUp);
            }
        });

    }
}