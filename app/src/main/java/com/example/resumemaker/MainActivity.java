package com.example.resumemaker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.resumemaker.databinding.ActivityMainBinding;
import com.example.resumemaker.fragment.HomeFragment;
import com.example.resumemaker.fragment.MyResumeFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Code for Hide appBar
       getSupportActionBar().hide();


       binding.bottomNavigationView.setBackground(null);

       binding.bottomNavigationView.setOnItemSelectedListener(item -> {
           switch(item.getItemId()){
               case R.id.home:
                   replaceFragment(new HomeFragment());
                   break;
               case R.id.resume:
                   replaceFragment(new MyResumeFragment());
                   break;
           }
           return true;
       });

       binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, CreateResumeDataActivity.class);
               startActivity(intent);
           }
       });
    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}