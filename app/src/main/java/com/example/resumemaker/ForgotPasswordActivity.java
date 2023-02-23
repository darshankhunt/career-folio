package com.example.resumemaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resumemaker.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {

    ActivityForgotPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = binding.tilForgotPasswordNumber.getEditText().getText().toString().trim();
                if(!number.isEmpty()){
                    if(number.length() == 10){
                        Intent intent = new Intent(ForgotPasswordActivity.this,EnterOtp.class);
                        intent.putExtra("mobile",number);
                        startActivity(intent);
                    }else {
                        Toast.makeText(ForgotPasswordActivity.this, "Please enter correct number.", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ForgotPasswordActivity.this, "Enter Mobile number.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}