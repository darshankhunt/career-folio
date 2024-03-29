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
import com.android.volley.toolbox.JsonArrayRequest;
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

import org.json.JSONArray;
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
        if (MyResumeFragment.editResume == true){
            //        Edit API Calling
            SharedPreferences sh1 = getActivity().getSharedPreferences("UserSignUpData", getContext().MODE_PRIVATE);
            String emailOfUser = sh1.getString("email","");
            String url = "http://172.20.10.5/resumepdfapi/fetchAllResumeDetailsGet.php?emailOfUser="+emailOfUser;
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    JSONArray jsonArray = response;
                    try {
                        for(int i=0;i<jsonArray.length();i++)
                        {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int ResumeTemplateId = jsonObject.getInt("ResumeTemplateId");
                            if(ResumeTemplateId==0){
                                binding.resumeTemplateCard0.setCardBackgroundColor(Color.GRAY);
                                binding.resumeTemplateCard1.setCardBackgroundColor(Color.WHITE);
                                binding.resumeTemplateCard2.setCardBackgroundColor(Color.WHITE);
                            } else if (ResumeTemplateId==1) {
                                binding.resumeTemplateCard0.setCardBackgroundColor(Color.WHITE);
                                binding.resumeTemplateCard2.setCardBackgroundColor(Color.WHITE);
                                binding.resumeTemplateCard1.setCardBackgroundColor(Color.GRAY);
                            } else if (ResumeTemplateId==2) {
                                binding.resumeTemplateCard0.setCardBackgroundColor(Color.WHITE);
                                binding.resumeTemplateCard1.setCardBackgroundColor(Color.WHITE);
                                binding.resumeTemplateCard2.setCardBackgroundColor(Color.GRAY);
                            }
                        }
                    }
                    catch (Exception w)
                    {
                        w.printStackTrace();
                        Toast.makeText(getContext(),w.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("ErrorAPI",error.getMessage());
                }
            });
            queue.add(jsonArrayRequest);
        }



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

                // Code for get EmailID
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserSignUpData", getContext().MODE_PRIVATE);
                String emailOfUser = sharedPreferences.getString("email","");
                boolean educationList = eduList.isEmpty();
                boolean skillsList = skillList.isEmpty();
                if(first_name.equals("") || last_name.equals("") || profession.equals("") || email.equals("") || MoNO.equals("") || Country.equals("") || objective.equals("") || educationList==true || skillsList==true){
//                    Toast.makeText(getActivity(), "about, contact, education,skill, and summary is necessary fields.", Toast.LENGTH_SHORT).show();
                    Log.i("Hello","First and last name is empty");
                }else {
                    UserModel u = new UserModel();
                    u.setResumeTemplateId(ResumeTemplateId);
                    u.setEmailOfUser(emailOfUser);;
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
                    String url ="http://172.20.10.5/resumepdfapi/create_api.php";
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
                                    //      Toast.makeText(getContext(), "Data Inserted!!", Toast.LENGTH_SHORT).show();
                                    try {
                                        int success=response.getInt("success");
                                        if(success==0){
                                            Toast.makeText(getActivity(), "Data not inserted", Toast.LENGTH_SHORT).show();
                                            Log.i("res1","Data not inserted");
                                        } else if (success==1) {
                                            MyResumeFragment.editResume=false;
                                            //Remove data on shared preference file
                                            editor.clear().apply();
//                                        Toast.makeText(getActivity(), "Data inserted", Toast.LENGTH_SHORT).show();
                                            Log.i("res1","Data inserted");
//                                            Intent intent = new Intent(getActivity(), MainActivity.class);
//                                            startActivity(intent);
//                                            getActivity().finish();
                                        }else if(success==-1){
//                                        Toast.makeText(getActivity(), "connection failed", Toast.LENGTH_SHORT).show();
                                            Log.i("res1","connection failed");
                                        }
                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }
//                                Toast.makeText(getContext(), "onResponse: "+response, Toast.LENGTH_SHORT).show();
                                    Log.i("API_responce", "onResponse: "+response);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_LONG).show();
                            Log.e("API_responce1", "onError: "+error.getLocalizedMessage());

                        }
                    });
                    queue.add(jsonObjectRequest);


                }


                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        return binding.getRoot();
    }
}