package com.example.resumemaker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText edEmail, edPassword;
    private Button btnLogin;
    private TextView txtSignUP, txtForgetPassword;
    private ImageView imgLoginGif;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();

        imgLoginGif = findViewById(R.id.imgLoginGif);
        edEmail = findViewById(R.id.edForgetEmail);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtSignUP = findViewById(R.id.txtSignUp);
        txtForgetPassword = findViewById(R.id.txtForgetPassword);

        //Load GIF Image
//        Glide.with(this).load(R.drawable.login_gif).into(imgLoginGif);

        //Login ButtonCode
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edEmail.getText().toString().trim();
                String password = edPassword.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(email.equals("")){
                    edEmail.setError("Enter your Email");
                } else if (!email.matches(emailPattern)) {
                    edEmail.setError("Invalid email address");
                } else if (password.equals("")) {
                    edPassword.setError("Enter your Password");
                } else if (password.length() < 6) {
                    Toast.makeText(LoginActivity.this, "Password must be 6 char long.", Toast.LENGTH_SHORT).show();
                } else{


                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        if(mAuth.getCurrentUser().isEmailVerified()){
                                            SharedPreferences sh = getSharedPreferences("UserSignUpData", MODE_PRIVATE);
                                            SharedPreferences.Editor editor =sh.edit();
                                            editor.putString("email",email);
                                            editor.commit();
                                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                            Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                                        }else {
                                            Toast.makeText(LoginActivity.this, "Please verify your email address!", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                    /*// API CODE
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    String url ="http://172.20.10.5/resumepdfapi/signupGet.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                    startActivity(intent);
//                                    Log.i("Hejghkj",response);
                                    if(response.equals("Invalid Credentials!")){
                                        Toast.makeText(LoginActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        SharedPreferences sharedPreferences = getSharedPreferences("UserSignUpData", MODE_PRIVATE);
                                        SharedPreferences.Editor editor1 = sharedPreferences.edit();
                                        editor1.putString("email",email);
                                        editor1.commit();
                                        startActivity(intent);
                                        finish();
                                        Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginActivity.this, "Data not saved.!", Toast.LENGTH_SHORT).show();
                        }
                    }){
                        protected Map<String, String> getParams(){
                            Map<String, String> paramV = new HashMap<>();
                            paramV.put("email", email);
                            paramV.put("password", password);
                            return paramV;
                        }
                    };
                    queue.add(stringRequest);
*/

//                    Toast.makeText(LoginActivity.this, ""+email+" hi "+password, Toast.LENGTH_SHORT).show();
                }
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