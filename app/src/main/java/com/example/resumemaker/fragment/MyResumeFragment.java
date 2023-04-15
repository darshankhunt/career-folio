package com.example.resumemaker.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.resumemaker.databinding.FragmentMyResumeBinding;


public class MyResumeFragment extends Fragment {

    FragmentMyResumeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyResumeBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment





        return binding.getRoot();
    }
}