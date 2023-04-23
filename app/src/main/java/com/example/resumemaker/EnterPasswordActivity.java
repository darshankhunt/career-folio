package com.example.resumemaker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class EnterPasswordActivity extends AppCompatActivity {


    private EditText edPass,edConPass;
    private Button btnEnterPassSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        //Code for Hide appBar
        if (getSupportActionBar() != null) {getSupportActionBar().hide();}

        edPass = findViewById(R.id.edPassword);
        edConPass = findViewById(R.id.edConPassword);
        btnEnterPassSubmit = findViewById(R.id.btnEnterPassSubmit);

//        Enter Password Button
        btnEnterPassSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = edPass.getText().toString();
                String conPassword = edConPass.getText().toString();
                String passPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
//                at least one digit, lower case, upper case, special char, no white space and at least 8 char.
                if(password.equals(null)){
                    edPass.setError("Enter your Password");
                } else if (conPassword.equals(null)) {
                    edConPass.setError("Enter your Confirm Password");
                } else if (password.matches(passPattern)) {
                    edPass.setError("Your password is not strong.");
                } else if (!password.equals(conPassword)) {
                    Toast.makeText(EnterPasswordActivity.this, "Your Password and Confirm Password does not matched.", Toast.LENGTH_SHORT).show();
                }else {
                    String email = getIntent().getStringExtra("email");
                    String fullName = getIntent().getStringExtra("full_name");
                    String number = getIntent().getStringExtra("number");

                    SharedPreferences sh = getSharedPreferences("UserSignUpData", MODE_PRIVATE);
                    SharedPreferences.Editor editor =sh.edit();
                    /*SignUpModel s = new SignUpModel(email,fullName,number);
                    s.setEmail(email);
                    s.setFullName(fullName);
                    s.setMobile(number);*/
                    editor.putString("email",email);
                    editor.putString("full_name",fullName);
                    editor.putString("number",number);
                    editor.commit();


                    // API CODE
                    RequestQueue queue = Volley.newRequestQueue(EnterPasswordActivity.this);
                    String url ="http://172.20.10.5/resumepdfapi/signupPost.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Intent intent = new Intent(EnterPasswordActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(EnterPasswordActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(EnterPasswordActivity.this, "Data not saved.!", Toast.LENGTH_SHORT).show();
                        }
                    }){
                        protected Map<String, String> getParams(){
                            Map<String, String> paramV = new HashMap<>();
                            paramV.put("email", email);
                            paramV.put("full_name", fullName);
                            paramV.put("number", number);
                            paramV.put("password", password);
                            return paramV;
                        }
                    };
                    queue.add(stringRequest);


//                    Toast.makeText(EnterPasswordActivity.this, "Your Password: "+passPattern, Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}