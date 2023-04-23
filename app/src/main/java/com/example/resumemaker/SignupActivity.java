package com.example.resumemaker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.resumemaker.Model.SignUpModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    ImageView imgSignupGif;

    EditText edNumber, edEmail, edFullName;
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
        edEmail = findViewById(R.id.edEmail);
        edFullName = findViewById(R.id.edFullname);
        edNumber = findViewById(R.id.edNumber);
        txtLogin = findViewById(R.id.txtLogin);
        btnSignupContinue = findViewById(R.id.btnSignupContinue);

        //Load GIF Image
//        Glide.with(this).load(R.drawable.signup_gif).into(imgSignupGif);

        //Continue Button Code
        btnSignupContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  email = edEmail.getText().toString().trim();
                String fullName = edFullName.getText().toString().trim();
                String number = edNumber.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(email.equals("")){
                    edEmail.setError("Enter your Email");
                } else if (!email.matches(emailPattern)) {
                    edEmail.setError("Invalid email address");
                } else if (fullName.equals("")) {
                    edFullName.setError("Enter your Full Name");
                } else if (number.equals("")) {
                    edNumber.setError("Enter Mobile Number");
                }else{
                    Intent intent = new Intent(SignupActivity.this, EnterPasswordActivity.class);
                    intent.putExtra("email",email);
                    intent.putExtra("full_name",fullName);
                    intent.putExtra("number",number);
                    startActivity(intent);


                    /*RequestQueue queue = Volley.newRequestQueue(SignupActivity.this);
                    String url ="http://172.20.10.5/resumepdfapi/signupPost.php";
                    String json = sh.getString("SignUpData", "");
                    JSONObject jsonObject;
                    try {
                        jsonObject=new JSONObject(json);
                        Log.i("json",""+jsonObject);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Toast.makeText(SignupActivity.this, "Register Successfully!!", Toast.LENGTH_SHORT).show();
                                    Log.i("API_responce", "onResponse: "+response);


                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Toast.makeText(getActivity(), ""+error.getMessage(), Toast.LENGTH_LONG).show();
                            Log.e("API_responce", "onError: "+error.getLocalizedMessage());

                        }
                    });
                    queue.add(jsonObjectRequest);*/

//                    Toast.makeText(SignupActivity.this, ""+email+" hi "+fullName+ "  "+number, Toast.LENGTH_SHORT).show();
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