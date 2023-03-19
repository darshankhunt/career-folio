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
import com.example.resumemaker.databinding.FragmentEducationBinding;
import com.example.resumemaker.databinding.FragmentWorkBinding;

public class EducationFragment extends Fragment implements View.OnClickListener{

    private static int count = 0;
    FragmentEducationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_education, container, false);
        binding = FragmentEducationBinding.inflate(inflater,container,false);


        binding.btnAddEdu.setOnClickListener(this);
        binding.btnRemoveCard0.setOnClickListener(this);
        binding.btnRemoveCard1.setOnClickListener(this);
        binding.btnRemoveCard2.setOnClickListener(this);




        return binding.getRoot();
    }

    public void removeCard(CardView workCard){
        count--;
        workCard.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAddEdu:
                if (count==0){
                    binding.EduCard0.setVisibility(View.VISIBLE);
                    count++;
                } else if(count==1){
                    binding.EduCard0.setVisibility(View.VISIBLE);
                    binding.EduCard1.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==2) {
                    binding.EduCard0.setVisibility(View.VISIBLE);
                    binding.EduCard1.setVisibility(View.VISIBLE);
                    binding.EduCard2.setVisibility(View.VISIBLE);
                    count++;
                } else if (count>=3) {
                    Toast.makeText(getActivity(), "You can't insert more than 3 Education.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRemoveCard0:
                removeCard(binding.EduCard0);
                break;
            case R.id.btnRemoveCard1:
                removeCard(binding.EduCard1);
                break;
            case R.id.btnRemoveCard2:
                removeCard(binding.EduCard2);
                break;
        }
    }
}