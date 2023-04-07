package com.example.resumemaker.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.R;
import com.example.resumemaker.databinding.FragmentEducationBinding;
import com.example.resumemaker.databinding.FragmentSkillsBinding;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SkillsFragment extends Fragment implements View.OnClickListener{


    private static int count = 0;

    FragmentSkillsBinding binding;
    private String  skillLevel0="Intermediate";
    private String  skillLevel1="Intermediate";
    private String  skillLevel2="Intermediate";
    private String  skillLevel3="Intermediate";

    private ArrayList<String> skillArr0;
    private ArrayList<String> skillArr1 = new ArrayList<String>();
    private ArrayList<String> skillArr2 = new ArrayList<String>();
    private ArrayList<String> skillArr3 = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_skills, container, false);
        binding = FragmentSkillsBinding.inflate(inflater,container,false);

        binding.btnAddSkills.setOnClickListener(this);
        binding.btnRemoveCard0.setOnClickListener(this);
        binding.btnRemoveCard1.setOnClickListener(this);
        binding.btnRemoveCard2.setOnClickListener(this);
        binding.btnRemoveCard3.setOnClickListener(this);


        binding.btnSkillSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(binding.SkillCard0.getVisibility() == View.VISIBLE){
                    String skill0 = binding.edSkillName0.getText().toString().trim();
                    binding.rgSkill0.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId == R.id.rBeginner0){
                                skillLevel0 = "Beginner";
                            } else if (checkedId == R.id.rIntermediate0) {
                                skillLevel0 = "Intermediate";
                            } else if (checkedId == R.id.rAdvanced0) {
                                skillLevel0 = "Advanced";
                            }else if(checkedId == R.id.rExpert0){
                                skillLevel0 = "Expert";
                            }
                        }
                    });

                    if(skill0.isEmpty()){
                        binding.edSkillName0.setError("Please enter skill");
                    }else {
//                        Code of Database
                        skillArr0 = new ArrayList<String>();
                        skillArr0.add(skill0);
                        skillArr0.add(skillLevel0);
                        Gson gson = new Gson();
                        String s0 = gson.toJson(skillArr0);
                        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =sh.edit();
                        editor.putString("skillArr0",s0);
                        editor.commit();

//                        Toast.makeText(getActivity(), ""+skill0+skillLevel0, Toast.LENGTH_SHORT).show();
                    }
                }

                if(binding.SkillCard1.getVisibility() == View.VISIBLE){
                    String skill1 = binding.edSkillName1.getText().toString().trim();
                    binding.rgSkill1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId == R.id.rBeginner1){
                                skillLevel1 = "Beginner";
                            } else if (checkedId == R.id.rIntermediate1) {
                                skillLevel1 = "Intermediate";
                            } else if (checkedId == R.id.rAdvanced1) {
                                skillLevel1 = "Advanced";
                            }else if(checkedId == R.id.rExpert1){
                                skillLevel1 = "Expert";
                            }
                        }
                    });

                    if(skill1.isEmpty()){
                        binding.edSkillName1.setError("Please enter skill");
                    }else {
//                        Code of Database
                        skillArr1 = new ArrayList<String>();
                        skillArr1.add(skill1);
                        skillArr1.add(skillLevel1);
                        Gson gson = new Gson();
                        String s1 = gson.toJson(skillArr1);
                        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =sh.edit();
                        editor.putString("skillArr1",s1);
                        editor.commit();
//                        Toast.makeText(getActivity(), ""+skill1+skillLevel1, Toast.LENGTH_SHORT).show();
                    }
                }

                if(binding.SkillCard2.getVisibility() == View.VISIBLE){
                    String skill2 = binding.edSkillName2.getText().toString().trim();
                    binding.rgSkill2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId == R.id.rBeginner2){
                                skillLevel2 = "Beginner";
                            } else if (checkedId == R.id.rIntermediate2) {
                                skillLevel2 = "Intermediate";
                            } else if (checkedId == R.id.rAdvanced2) {
                                skillLevel2 = "Advanced";
                            }else if(checkedId == R.id.rExpert2){
                                skillLevel2 = "Expert";
                            }
                        }
                    });

                    if(skill2.isEmpty()){
                        binding.edSkillName2.setError("Please enter skill");
                    }else {
//                        Code of Database
                        skillArr2 = new ArrayList<String>();
                        skillArr2.add(skill2);
                        skillArr2.add(skillLevel2);
                        Gson gson = new Gson();
                        String s2 = gson.toJson(skillArr2);
                        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =sh.edit();
                        editor.putString("skillArr2",s2);
                        editor.commit();
//                        Toast.makeText(getActivity(), ""+skill2+skillLevel2, Toast.LENGTH_SHORT).show();
                    }
                }

                if(binding.SkillCard3.getVisibility() == View.VISIBLE){
                    String skill3 = binding.edSkillName3.getText().toString().trim();
                    binding.rgSkill3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId == R.id.rBeginner3){
                                skillLevel3 = "Beginner";
                            } else if (checkedId == R.id.rIntermediate3) {
                                skillLevel3 = "Intermediate";
                            } else if (checkedId == R.id.rAdvanced3) {
                                skillLevel3 = "Advanced";
                            }else if(checkedId == R.id.rExpert3){
                                skillLevel3 = "Expert";
                            }
                        }
                    });

                    if(skill3.isEmpty()){
                        binding.edSkillName3.setError("Please enter skill");
                    }else {
//                        Code of Database
                        skillArr3 = new ArrayList<String>();
                        skillArr3.add(skill3);
                        skillArr3.add(skillLevel3);
                        Gson gson = new Gson();
                        String s3 = gson.toJson(skillArr3);
                        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =sh.edit();
                        editor.putString("skillArr3",s3);
                        editor.commit();
//                        Toast.makeText(getActivity(), ""+skill3+skillLevel3, Toast.LENGTH_SHORT).show();
                    }
                }

                CreateResumeDataActivity.viewPager2.setCurrentItem(5);
            }
        });

        return binding.getRoot();
    }

    public void removeCard(CardView skillCard){
        count--;
        skillCard.setVisibility(View.GONE);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAddSkills:
                if (count==0){
                    binding.SkillCard0.setVisibility(View.VISIBLE);
                    count++;
                } else if(count==1){
                    binding.SkillCard0.setVisibility(View.VISIBLE);
                    binding.SkillCard1.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==2) {
                    binding.SkillCard0.setVisibility(View.VISIBLE);
                    binding.SkillCard1.setVisibility(View.VISIBLE);
                    binding.SkillCard2.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==3) {
                    binding.SkillCard0.setVisibility(View.VISIBLE);
                    binding.SkillCard1.setVisibility(View.VISIBLE);
                    binding.SkillCard2.setVisibility(View.VISIBLE);
                    binding.SkillCard3.setVisibility(View.VISIBLE);
                    count++;
                } else if (count>=4) {
                    Toast.makeText(getActivity(), "You can't insert more than 4 skills.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRemoveCard0:
                removeCard(binding.SkillCard0);
                break;
            case R.id.btnRemoveCard1:
                removeCard(binding.SkillCard1);
                break;
            case R.id.btnRemoveCard2:
                removeCard(binding.SkillCard2);
                break;
            case R.id.btnRemoveCard3:
                removeCard(binding.SkillCard3);
                break;
        }
    }
}