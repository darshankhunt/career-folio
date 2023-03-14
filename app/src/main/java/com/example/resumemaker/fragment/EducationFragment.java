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

public class EducationFragment extends Fragment {
    public EducationFragment() {
        // Required empty public constructor
    }


    private Button btnAddEdu;
    private int count = 0;
    private CardView eduCard0, eduCard1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_education, container, false);


        btnAddEdu = view.findViewById(R.id.btnAddEdu);
        eduCard0 = view.findViewById(R.id.EduCard0);
        eduCard1 = view.findViewById(R.id.EduCard1);


        btnAddEdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count==0){
                    eduCard0.setVisibility(View.VISIBLE);
                    count++;
                } else if(count==1){
                    eduCard1.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==2) {
                    Toast.makeText(getActivity(), "You can't insert more than 2 Education.", Toast.LENGTH_SHORT).show();
                }
            }
        });




        return view;
    }
}