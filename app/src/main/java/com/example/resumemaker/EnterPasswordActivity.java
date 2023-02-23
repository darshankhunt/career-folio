package com.example.resumemaker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class EnterPasswordActivity extends AppCompatActivity {


    private TextInputLayout tilEnterPassword, tilEnterConPassword;
    private Button btnEnterPassSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        tilEnterPassword = findViewById(R.id.tilEnterPassword);
        tilEnterConPassword = findViewById(R.id.tilEnterConPassword);
        btnEnterPassSubmit = findViewById(R.id.btnEnterPassSubmit);

//        Enter Password Button
        btnEnterPassSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = tilEnterConPassword.getEditText().getText().toString().trim();
                String conPassword = tilEnterConPassword.getEditText().getText().toString().trim();
                String passPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
//                at least one digit, lower case, upper case, special char, no white space and at least 8 char.
                if(password.equals(null)){
                    tilEnterPassword.setError("Enter your Password");
                } else if (conPassword.equals(null)) {
                    tilEnterConPassword.setError("Enter your Password");
                } else if (password.matches(passPattern)) {
                    tilEnterPassword.setError("Your password must be at least one digit, one lower case and once upper case character, once special character, must be 8 character no whitespace allowed.");
                } else if (conPassword.matches(passPattern)) {
                    tilEnterPassword.setError("Your password must be at least one digit, one lower case and once upper case character, once special character, must be 8 character no whitespace allowed.");
                } else if (!password.equals(conPassword)) {
                    Toast.makeText(EnterPasswordActivity.this, "Your Password and Confirm Password does not matched.", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(EnterPasswordActivity.this, "Your Password: "+passPattern, Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}