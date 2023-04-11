package com.example.resumemaker.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.Model.UserModel;
import com.example.resumemaker.R;
import com.example.resumemaker.databinding.FragmentSkillsBinding;
import com.example.resumemaker.databinding.FragmentSummaryBinding;

import java.util.ArrayList;

public class SummaryFragment extends Fragment {

    FragmentSummaryBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSummaryBinding.inflate(inflater,container,false);
        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sh.edit();

        String ob = sh.getString("objective","");
        if(!ob.equals(""))
            binding.edObjective.setText(ob);

        binding.btnSummarySave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String objective = binding.edObjective.getText().toString().trim();
                if(objective.isEmpty()){
                    binding.edObjective.setError("Please enter objective");
                } else if (objective.length()>299) {
                    Toast.makeText(getActivity(), "your objective is too long.", Toast.LENGTH_SHORT).show();
                } else {
//                    Code of Database

                    UserModel u = new UserModel(objective);
                    u.setObjective(objective);
                    editor.putString("objective", u.getObjective());
                    editor.commit();
                    CreateResumeDataActivity.viewPager2.setCurrentItem(6);
//                    Toast.makeText(getActivity(), ""+objective, Toast.LENGTH_SHORT).show();
                }
            }
        });



        return binding.getRoot();
    }
}