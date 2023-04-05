package com.example.resumemaker.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.HomeSc;
import com.example.resumemaker.R;
import com.example.resumemaker.databinding.FragmentDoneBinding;

public class DoneFragment extends Fragment {

    FragmentDoneBinding binding;

    private int resumeTemplateId = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDoneBinding.inflate(inflater,container,false);

        binding.resumeTemplateCard0.setCardBackgroundColor(Color.GRAY);

        binding.resumeTemplateCard0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resumeTemplateId!=0){
                    binding.resumeTemplateCard0.setCardBackgroundColor(Color.GRAY);
                    binding.resumeTemplateCard1.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard2.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard3.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard4.setCardBackgroundColor(Color.WHITE);
                    resumeTemplateId=0;
                }
            }
        });

        binding.resumeTemplateCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resumeTemplateId!=1){
                    binding.resumeTemplateCard0.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard1.setCardBackgroundColor(Color.GRAY);
                    binding.resumeTemplateCard2.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard3.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard4.setCardBackgroundColor(Color.WHITE);
                    resumeTemplateId=1;
                }
            }
        });

        binding.resumeTemplateCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resumeTemplateId!=2){
                    binding.resumeTemplateCard0.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard1.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard2.setCardBackgroundColor(Color.GRAY);
                    binding.resumeTemplateCard3.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard4.setCardBackgroundColor(Color.WHITE);
                    resumeTemplateId=2;
                }
            }
        });

        binding.resumeTemplateCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resumeTemplateId!=3){
                    binding.resumeTemplateCard0.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard1.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard2.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard3.setCardBackgroundColor(Color.GRAY);
                    binding.resumeTemplateCard4.setCardBackgroundColor(Color.WHITE);
                    resumeTemplateId=3;
                }
            }
        });

        binding.resumeTemplateCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resumeTemplateId!=4){
                    binding.resumeTemplateCard0.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard1.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard2.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard3.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard4.setCardBackgroundColor(Color.GRAY);
                    resumeTemplateId=4;
                }
            }
        });


        binding.btnCreateResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Code of Database
                SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sh.edit();
                editor.putInt("ResumeTemplateId", resumeTemplateId);
                editor.commit();

//                Code of API

                Intent intent = new Intent(getActivity(), HomeSc.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        return binding.getRoot();
    }
}