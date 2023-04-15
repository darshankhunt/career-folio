package com.example.resumemaker.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.resumemaker.MainActivity;
import com.example.resumemaker.Model.EducationModel;
import com.example.resumemaker.Model.SkillModel;
import com.example.resumemaker.Model.UserModel;
import com.example.resumemaker.Model.WorkModel;
import com.example.resumemaker.databinding.FragmentDoneBinding;
import com.example.resumemaker.databinding.FragmentHomeBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DoneFragment extends Fragment {

    FragmentDoneBinding binding;

    private int resumeTemplateId = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDoneBinding.inflate(inflater,container,false);

        binding.resumeTemplateCard0.setCardBackgroundColor(Color.GRAY);

        Gson gson = new Gson();

        binding.resumeTemplateCard0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resumeTemplateId!=0){
                    binding.resumeTemplateCard0.setCardBackgroundColor(Color.GRAY);
                    binding.resumeTemplateCard1.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard2.setCardBackgroundColor(Color.WHITE);
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
                    resumeTemplateId=2;
                }
            }
        });


        binding.btnCreateResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Code of Database
                SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sh.edit();
                editor.putInt("ResumeTemplateId", resumeTemplateId);
                editor.commit();

// Code of API
                String first_name = sh.getString("first_name","");
                String last_name = sh.getString("last_name","");
                String profession = sh.getString("profession","");
                String email = sh.getString("email","");
                String MoNO = sh.getString("MoNO","");
                String Website = sh.getString("Website","");
                String Country = sh.getString("Country","");
                String objective = sh.getString("objective","");
                int ResumeTemplateId = sh.getInt("ResumeTemplateId",0);

                // Code for WorkData
                String jsonWorkArr = sh.getString("workList", "");
                Type typeWork = new TypeToken<ArrayList<WorkModel>>() {
                }.getType();
                ArrayList<WorkModel> workList = gson.fromJson(jsonWorkArr, typeWork);

                // Code for EduData
                String jsonEduArr = sh.getString("eduList", "");
                Type typeEdu = new TypeToken<ArrayList<EducationModel>>() {
                }.getType();
                ArrayList<EducationModel> eduList = gson.fromJson(jsonEduArr, typeEdu);

                // Code for SkillData
                String jsonSkillArr = sh.getString("skillList", "");
                Type typeSkill = new TypeToken<ArrayList<SkillModel>>() {
                }.getType();
                ArrayList<SkillModel> skillList = gson.fromJson(jsonSkillArr, typeSkill);


                UserModel u = new UserModel(resumeTemplateId,first_name,last_name,profession,email,MoNO,Website,Country,objective,workList,eduList,skillList);
                u.setResumeTemplateId(ResumeTemplateId);
                u.setfName(first_name);
                u.setlName(last_name);
                u.setProfession(profession);
                u.setEmail(email);
                u.setContactNumber(MoNO);
                u.setWebsite(Website);
                u.setCountry(Country);
                u.setObjective(objective);
                u.setWorkList(workList);
                u.setEduList(eduList);
                u.setSkillList(skillList);
                Gson gsonFinal = new Gson();
                String jsonFinal = gsonFinal.toJson(u);
                editor.putString("FinalData",jsonFinal);
                editor.commit();



                // API CODE
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                String url ="http://172.20.10.5/resumepdfapi/create.php";
                String json = sh.getString("FinalData", "");
                JSONObject jsonObject;
                try {
                     jsonObject=new JSONObject(json);
                    Log.i("json",""+jsonObject);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

              JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getActivity(), "Data Inserted!!", Toast.LENGTH_SHORT).show();
                                Log.i("API_responce", "onResponse: "+response);


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       // Toast.makeText(getActivity(), ""+error.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("API_responce", "onError: "+error.getLocalizedMessage());

                    }
                });
                queue.add(jsonObjectRequest);

                //Remove data on shared preference file
                //editor.clear().apply();

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        return binding.getRoot();
    }
}