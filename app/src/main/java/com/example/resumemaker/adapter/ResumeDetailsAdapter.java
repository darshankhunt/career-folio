package com.example.resumemaker.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.resumemaker.fragment.AboutFragment;
import com.example.resumemaker.fragment.ContactFragment;
import com.example.resumemaker.fragment.ThirdFragment;

public class ResumeDetailsAdapter extends FragmentStateAdapter {

    public ResumeDetailsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1:
                return  new ContactFragment();
            case 2:
                return  new ThirdFragment();
        }


        return new AboutFragment();
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
