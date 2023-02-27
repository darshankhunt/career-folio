package com.example.resumemaker;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.resumemaker.databinding.ActivityEnterOtpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class EnterOtp extends AppCompatActivity {

    ActivityEnterOtpBinding binding;
    private static String getOTPBackEnd;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Code for Hide appBar
        if (getSupportActionBar() != null) {getSupportActionBar().hide();}

        mAuth = FirebaseAuth.getInstance();
        // set this to remove reCaptcha web
//        mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);

        binding.txtNumber.setText(String.format("+91-%s",getIntent().getStringExtra("mobile")));
        getOTPBackEnd = getIntent().getStringExtra("backEndOTP");
//        Log.d("Hellop", "onCreate: "+getOTPBackEnd);

//        Code of Check OTP
        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp1 = binding.edOTP1.getText().toString().trim();
                String otp2 = binding.edOTP2.getText().toString().trim();
                String otp3 = binding.edOTP3.getText().toString().trim();
                String otp4 = binding.edOTP4.getText().toString().trim();
                String otp5 = binding.edOTP5.getText().toString().trim();
                String otp6 = binding.edOTP6.getText().toString().trim();

                if(!otp1.isEmpty() && !otp2.isEmpty() && !otp3.isEmpty() && !otp4.isEmpty() && !otp5.isEmpty() && !otp6.isEmpty()){
                    String enterCodeOTP = otp1+otp2+otp3+otp4+otp5+otp6;
                    if(!getOTPBackEnd.equals("")){
                        binding.progressBar2.setVisibility(view.VISIBLE);
                        binding.btnContinue.setVisibility(view.INVISIBLE);
//                        Log.d("usOTP",  "onc: "+enterCodeOTP);
                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(getOTPBackEnd,enterCodeOTP);
                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                binding.progressBar2.setVisibility(view.INVISIBLE);
                                binding.btnContinue.setVisibility(view.VISIBLE);

                                if(task.isSuccessful()){
                                    Intent intent = new Intent(EnterOtp.this,EnterPasswordActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(EnterOtp.this, "Enter the correct OTP.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }else {
                        Toast.makeText(EnterOtp.this, "Please check the internet connection", Toast.LENGTH_SHORT).show();
                    }

//                    Toast.makeText(EnterOtp.this, "otp verify", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(EnterOtp.this,EnterPasswordActivity.class);
//                    startActivity(intent);
                }else {
                    Toast.makeText(EnterOtp.this, "please enter all number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        numberOTPMove();

//      Code of Resend OTP
        binding.txtResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.edOTP1.setText("");
                binding.edOTP2.setText("");
                binding.edOTP3.setText("");
                binding.edOTP4.setText("");
                binding.edOTP5.setText("");
                binding.edOTP6.setText("");
                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(mAuth)
                                .setPhoneNumber("+91"+getIntent().getStringExtra("mobile"))       // Phone number to verify
                                .setTimeout(10L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(EnterOtp.this)                 // Activity (for callback binding)
                                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        Toast.makeText(EnterOtp.this, "Resend OTP Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String newBackEndOTP, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        getOTPBackEnd = newBackEndOTP;
                                        Toast.makeText(EnterOtp.this, "OTP sent successfully.", Toast.LENGTH_SHORT).show();
                                    }
                                })          // OnVerificationStateChangedCallbacks
                                .build();
                PhoneAuthProvider.verifyPhoneNumber(options);
            }
        });

    }

    private void numberOTPMove() {
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