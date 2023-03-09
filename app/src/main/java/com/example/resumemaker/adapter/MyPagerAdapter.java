package com.example.resumemaker.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.resumemaker.fragment.HomeFragment;
import com.example.resumemaker.fragment.SecondFragment;
import com.example.resumemaker.fragment.ThirdFragment;

public class MyPagerAdapter extends FragmentStateAdapter {

    public MyPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1:
                return  new SecondFragment();
            case 2:
                return  new ThirdFragment();
        }


        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
