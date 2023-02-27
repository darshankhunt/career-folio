package com.example.resumemaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.resumemaker.databinding.ActivityForgotPasswordBinding;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    ActivityForgotPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mAuth = FirebaseAuth.getInstance();
        // set this to remove reCaptcha web
//        mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);

        binding.btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = binding.tilForgotPasswordNumber.getEditText().getText().toString().trim();
                if(!number.isEmpty()){
                    if(number.length() == 10){
                        binding.progressBar.setVisibility(view.VISIBLE);
                        binding.btnForgotPassword.setVisibility(view.INVISIBLE);
                        PhoneAuthOptions options =
                                PhoneAuthOptions.newBuilder(mAuth)
                                        .setPhoneNumber("+91"+number)       // Phone number to verify
                                        .setTimeout(10L, TimeUnit.SECONDS) // Timeout and unit
                                        .setActivity(ForgotPasswordActivity.this)                 // Activity (for callback binding)
                                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                            @Override
                                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                                binding.progressBar.setVisibility(view.INVISIBLE);
                                                binding.btnForgotPassword.setVisibility(view.VISIBLE);
                                            }

                                            @Override
                                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                                binding.progressBar.setVisibility(view.VISIBLE);
                                                binding.btnForgotPassword.setVisibility(view.INVISIBLE);
                                                Toast.makeText(ForgotPasswordActivity.this, "Error please check internet connection.", Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void onCodeSent(@NonNull String backEndOTP, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                                binding.progressBar.setVisibility(view.VISIBLE);
                                                binding.btnForgotPassword.setVisibility(view.INVISIBLE);
                                                Intent intent = new Intent(ForgotPasswordActivity.this,EnterOtp.class);
                                                intent.putExtra("mobile",number);
                                                intent.putExtra("backEndOTP",backEndOTP);
                                                startActivity(intent);
                                            }
                                        })          // OnVerificationStateChangedCallbacks
                                        .build();
                        PhoneAuthProvider.verifyPhoneNumber(options);
//                        PhoneAuthProvider.getInstance().verifyPhoneNumber();

//                        Intent intent = new Intent(ForgotPasswordActivity.this,EnterOtp.class);
//                        intent.putExtra("mobile",number);
//                        startActivity(intent);
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