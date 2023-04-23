package com.example.resumemaker.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.R;
import com.example.resumemaker.databinding.FragmentMyResumeBinding;


public class MyResumeFragment extends Fragment {

    FragmentMyResumeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyResumeBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment

        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sh.edit();
        int ResumeTemplateId = sh.getInt("ResumeTemplateId",0);

        if(ResumeTemplateId==0){
            binding.imgResume.setImageResource(R.mipmap.resume0);
        } else if (ResumeTemplateId==1) {
            binding.imgResume.setImageResource(R.mipmap.resume1);
        } else if (ResumeTemplateId==2) {
            binding.imgResume.setImageResource(R.mipmap.resume2);
        }else{
            binding.imgResume.setImageResource(R.mipmap.resume0);
        }

        binding.btnDownloadResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Download Resume", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnEditResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateResumeDataActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        binding.btnRemoveResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                editor.remove("ResumeTemplateId");

                Toast.makeText(getActivity(), "Delete Resume", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }
}