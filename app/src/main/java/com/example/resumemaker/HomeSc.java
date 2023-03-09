package com.example.resumemaker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.resumemaker.databinding.ActivityHomeScBinding;


public class HomeSc extends AppCompatActivity {

    ActivityHomeScBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_home_sc);
        binding.svHome.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY > oldScrollY + 12 && binding.expandedFab.isExtended()){
                    binding.expandedFab.shrink();
                }
                if(scrollY <oldScrollY - 12 & !binding.expandedFab.isExtended()){
                    binding.expandedFab.extend();
                }
                if(scrollX == 0){
                    binding.expandedFab.extend();
                }
            }
        });
    }
}