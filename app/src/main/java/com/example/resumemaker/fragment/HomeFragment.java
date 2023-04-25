package com.example.resumemaker.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.resumemaker.ForgotPasswordActivity;
import com.example.resumemaker.LoginActivity;
import com.example.resumemaker.MainActivity;
import com.example.resumemaker.R;
import com.example.resumemaker.SplashScreenActivity;
import com.example.resumemaker.databinding.FragmentHomeBinding;
import com.example.resumemaker.resumeTemplateOne;
import com.example.resumemaker.resumeTemplateTwo;
import com.example.resumemaker.resumeTemplateZero;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false);



        binding.resumeTemplate0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), resumeTemplateZero.class);
                startActivity(intent);
            }
        });
        binding.resumeTemplate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), resumeTemplateOne.class);
                startActivity(intent);
            }
        });
        binding.resumeTemplate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), resumeTemplateTwo.class);
                startActivity(intent);
            }
        });



        binding.UserIconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getContext(),binding.UserIconButton);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId() == R.id.logOut){
                            SharedPreferences sh = getContext().getSharedPreferences("UserSignUpData", getContext().MODE_PRIVATE);
                            sh.edit().remove("email").commit();
                            Intent intent = new Intent(getContext(), SplashScreenActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                            Toast.makeText(getContext(), "Logout Successfully.", Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.changePassword) {
                            FirebaseAuth mAuth = FirebaseAuth.getInstance();
                            SharedPreferences sh = getContext().getSharedPreferences("UserSignUpData", getContext().MODE_PRIVATE);
                            String email = sh.getString("email","");
                            if(!email.equals("")){
                                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(getContext(), "Password send to your email", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getContext(), LoginActivity.class);
                                            startActivity(intent);
                                            getActivity().finish();
                                        }else {
                                            Toast.makeText(getContext(), ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }else {
                                Toast.makeText(getContext(), "Password not Changed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        return true;
                    }
                });
                popup.show();

            }
        });

        return binding.getRoot();
    }
}