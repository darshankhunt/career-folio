package com.example.resumemaker;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resumemaker.databinding.ActivityEnterOtpBinding;

public class EnterOtp extends AppCompatActivity {

    ActivityEnterOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String otp1 = binding.edOTP1.getText().toString().trim();
        String otp2 = binding.edOTP2.getText().toString().trim();
        String otp3 = binding.edOTP3.getText().toString().trim();
        String otp4 = binding.edOTP4.getText().toString().trim();
        String otp5 = binding.edOTP5.getText().toString().trim();
        String otp6 = binding.edOTP6.getText().toString().trim();
        binding.txtNumber.setText(String.format("+91-%s",getIntent().getStringExtra("mobile")));

        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(otp1.isEmpty() && otp2.isEmpty() && otp3.isEmpty() && otp4.isEmpty() && otp5.isEmpty() && otp6.isEmpty()){
                    Toast.makeText(EnterOtp.this, "otp verify", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnterOtp.this,EnterPasswordActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(EnterOtp.this, "please enter all number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        numberotpmove();

    }

    private void numberotpmove() {
        binding.edOTP1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    binding.edOTP2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.edOTP2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    binding.edOTP3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.edOTP3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    binding.edOTP4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.edOTP4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    binding.edOTP5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.edOTP5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    binding.edOTP6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}