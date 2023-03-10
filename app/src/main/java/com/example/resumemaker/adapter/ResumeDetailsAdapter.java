package com.example.resumemaker.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.resumemaker.fragment.AboutFragment;
import com.example.resumemaker.fragment.ContactFragment;
import com.example.resumemaker.fragment.DoneFragment;
import com.example.resumemaker.fragment.EducationFragment;
import com.example.resumemaker.fragment.SkillsFragment;
import com.example.resumemaker.fragment.SummaryFragment;
import com.example.resumemaker.fragment.WorkFragment;

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
                return  new WorkFragment();
            case 3:
                return  new EducationFragment();
            case 4:
                return  new SkillsFragment();
            case 5:
                return  new SummaryFragment();
            case 6:
                return  new DoneFragment();
        }
        return new AboutFragment();
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
