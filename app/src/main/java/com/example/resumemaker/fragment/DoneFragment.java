package com.example.resumemaker.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.fragment.app.Fragment;

import com.example.resumemaker.R;
import com.example.resumemaker.adapter.ResumeTemplateAdapter;
import com.example.resumemaker.databinding.FragmentDoneBinding;

public class DoneFragment extends Fragment {

    FragmentDoneBinding binding;

    private int[] arrResumeTemplate = {R.drawable.ic_tab_contact,R.drawable.ic_tab_contact,
            R.drawable.ic_tab_contact,R.drawable.ic_tab_contact,R.drawable.ic_tab_contact,R.drawable.ic_tab_contact};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDoneBinding.inflate(inflater,container,false);


        ResumeTemplateAdapter adapter = new ResumeTemplateAdapter(getActivity(),arrResumeTemplate);
        binding.gridview.setAdapter(adapter);




        return binding.getRoot();
    }
}