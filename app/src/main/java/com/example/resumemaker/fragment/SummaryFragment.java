package com.example.resumemaker.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.resumemaker.R;
import com.example.resumemaker.databinding.FragmentSkillsBinding;
import com.example.resumemaker.databinding.FragmentSummaryBinding;

public class SummaryFragment extends Fragment {

    FragmentSummaryBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        binding = FragmentSummaryBinding.inflate(inflater,container,false);

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
                    Toast.makeText(getActivity(), ""+objective, Toast.LENGTH_SHORT).show();
                }
            }
        });



        return binding.getRoot();
    }
}