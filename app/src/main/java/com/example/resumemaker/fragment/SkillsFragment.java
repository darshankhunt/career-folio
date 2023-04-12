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
import com.example.resumemaker.Model.SkillModel;
import com.example.resumemaker.Model.WorkModel;
import com.example.resumemaker.R;
import com.example.resumemaker.databinding.FragmentEducationBinding;
import com.example.resumemaker.databinding.FragmentSkillsBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SkillsFragment extends Fragment implements View.OnClickListener{


    private static int count = 0;

    FragmentSkillsBinding binding;
    private String skillLevel0="Intermediate";
    private String  skillLevel1="Intermediate";
    private String  skillLevel2="Intermediate";
    private String  skillLevel3="Intermediate";

    private ArrayList<SkillModel> skillArr0;
    private ArrayList<SkillModel> skillArr1;
    private ArrayList<SkillModel> skillArr2;
    private ArrayList<SkillModel> skillArr3;

    private ArrayList<SkillModel> skillList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSkillsBinding.inflate(inflater,container,false);
        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sh.edit();
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<SkillModel>>() {}.getType();
        String sA0 = sh.getString("skillArr0","");
        List<SkillModel> sAL0 = gson.fromJson(sA0, type);
        String sA1 = sh.getString("skillArr1","");
        List<SkillModel> sAL1 = gson.fromJson(sA1, type);
        String sA2 = sh.getString("skillArr2","");
        List<SkillModel> sAL2 = gson.fromJson(sA2, type);
        String sA3 = sh.getString("skillArr3","");
        List<SkillModel> sAL3 = gson.fromJson(sA3, type);


        if(sAL0==null){
            binding.SkillCard0.setVisibility(View.GONE);
        }else {
            binding.SkillCard0.setVisibility(View.VISIBLE);
            count++;
            binding.edSkillName0.setText(sAL0.get(0).getSkill());
            String value = sAL0.get(0).getSkillLevel();
            if(value=="Beginner"){
                binding.rBeginner0.setChecked(true);
            }else if(value=="Intermediate"){
                binding.rIntermediate0.setChecked(true);
            }else if(value=="Advanced"){
                binding.rAdvanced0.setChecked(true);
            }else if(value=="Expert"){
                binding.rExpert0.setChecked(true);
            }
        }
        if(sAL1==null){
            binding.SkillCard1.setVisibility(View.GONE);
        }else {
            binding.SkillCard1.setVisibility(View.VISIBLE);
            count++;
            binding.edSkillName1.setText(sAL1.get(0).getSkill());

        }
        if(sAL2==null){
            binding.SkillCard2.setVisibility(View.GONE);
        }else {
            binding.SkillCard2.setVisibility(View.VISIBLE);
            count++;
            binding.edSkillName2.setText(sAL2.get(0).getSkill());
        }
        if(sAL3==null){
            binding.SkillCard3.setVisibility(View.GONE);
        }else {
            binding.SkillCard3.setVisibility(View.VISIBLE);
            count++;
            binding.edSkillName3.setText(sAL3.get(0).getSkill());
        }

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

                        SkillModel s0 = new SkillModel(skill0,skillLevel0);
                        s0.setSkill(skill0);
                        s0.setSkillLevel(skillLevel0);
                        skillList = new ArrayList<>();
                        skillList.add(s0);
                        String skil0 = gson.toJson(skillList);
                        editor.putString("skillList", skil0);
                        editor.commit();

                        skillArr0 = new ArrayList<SkillModel>();
                        skillArr0.add(s0);
                        String sj0 = gson.toJson(skillArr0);
                        editor.putString("skillArr0",sj0);
                        editor.commit();
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

                        SkillModel s1 = new SkillModel(skill1,skillLevel1);
                        s1.setSkill(skill1);
                        s1.setSkillLevel(skillLevel1);
                        skillList = new ArrayList<>();
                        skillList.add(s1);
                        String skil1 = gson.toJson(skillList);
                        editor.putString("skillList", skil1);
                        editor.commit();

                        skillArr1 = new ArrayList<SkillModel>();
                        skillArr1.add(s1);
                        String sj1 = gson.toJson(skillArr1);
                        editor.putString("skillArr1",sj1);
                        editor.commit();

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

                        SkillModel s2 = new SkillModel(skill2,skillLevel2);
                        s2.setSkill(skill2);
                        s2.setSkillLevel(skillLevel2);
                        skillList = new ArrayList<>();
                        skillList.add(s2);
                        String skil2 = gson.toJson(skillList);
                        editor.putString("skillList", skil2);
                        editor.commit();

                        skillArr2 = new ArrayList<SkillModel>();
                        skillArr2.add(s2);
                        String sj2 = gson.toJson(skillArr2);
                        editor.putString("skillArr2",sj2);
                        editor.commit();
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

                        SkillModel s3 = new SkillModel(skill3,skillLevel3);
                        s3.setSkill(skill3);
                        s3.setSkillLevel(skillLevel3);
                        skillList = new ArrayList<>();
                        skillList.add(s3);
                        String skil3 = gson.toJson(skillList);
                        editor.putString("skillList", skil3);
                        editor.commit();

                        skillArr3 = new ArrayList<SkillModel>();
                        skillArr3.add(s3);
                        String sj3 = gson.toJson(skillArr3);
                        editor.putString("skillArr3",sj3);
                        editor.commit();
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