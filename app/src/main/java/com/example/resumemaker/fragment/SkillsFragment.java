package com.example.resumemaker.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.resumemaker.R;

public class SkillsFragment extends Fragment {
    public SkillsFragment() {
        // Required empty public constructor
    }

    private Button btnAddSkill;
    private CardView skillCard0, skillCard1, skillCard2, skillCard3;
    private int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skills, container, false);

        btnAddSkill = view.findViewById(R.id.btnAddSkills);
        skillCard0 = view.findViewById(R.id.SkillCard0);
        skillCard1 = view.findViewById(R.id.SkillCard1);
        skillCard2 = view.findViewById(R.id.SkillCard2);
        skillCard3 = view.findViewById(R.id.SkillCard3);




        btnAddSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count==0){
                    skillCard0.setVisibility(View.VISIBLE);
                    count++;
                } else if(count==1){
                    skillCard1.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==2) {
                    skillCard2.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==3) {
                    skillCard3.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==4) {
                    Toast.makeText(getActivity(), "You can't insert more than 4 Skills.", Toast.LENGTH_SHORT).show();
                }
            }
        });




        return view;
    }
}