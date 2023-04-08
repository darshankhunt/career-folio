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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.HomeSc;
import com.example.resumemaker.Model.UserModel;
import com.example.resumemaker.R;
import com.example.resumemaker.databinding.FragmentDoneBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoneFragment extends Fragment {

    FragmentDoneBinding binding;

    private int resumeTemplateId = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDoneBinding.inflate(inflater,container,false);

        binding.resumeTemplateCard0.setCardBackgroundColor(Color.GRAY);

        binding.resumeTemplateCard0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resumeTemplateId!=0){
                    binding.resumeTemplateCard0.setCardBackgroundColor(Color.GRAY);
                    binding.resumeTemplateCard1.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard2.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard3.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard4.setCardBackgroundColor(Color.WHITE);
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
                    binding.resumeTemplateCard3.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard4.setCardBackgroundColor(Color.WHITE);
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
                    binding.resumeTemplateCard3.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard4.setCardBackgroundColor(Color.WHITE);
                    resumeTemplateId=2;
                }
            }
        });

        binding.resumeTemplateCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resumeTemplateId!=3){
                    binding.resumeTemplateCard0.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard1.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard2.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard3.setCardBackgroundColor(Color.GRAY);
                    binding.resumeTemplateCard4.setCardBackgroundColor(Color.WHITE);
                    resumeTemplateId=3;
                }
            }
        });

        binding.resumeTemplateCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resumeTemplateId!=4){
                    binding.resumeTemplateCard0.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard1.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard2.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard3.setCardBackgroundColor(Color.WHITE);
                    binding.resumeTemplateCard4.setCardBackgroundColor(Color.GRAY);
                    resumeTemplateId=4;
                }
            }
        });


        binding.btnCreateResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Code of Database
                UserModel u = new UserModel(resumeTemplateId);
                u.setResumeTemplateId(resumeTemplateId);

                SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sh.edit();
                editor.putInt("ResumeTemplateId", u.getResumeTemplateId());
                editor.commit();

//                Code of API

                String first_name = sh.getString("first_name","");
                String last_name = sh.getString("last_name","");
                String profession = sh.getString("profession","");
                String email = sh.getString("email","");
                String MoNO = sh.getString("MoNO","");
                String Website = sh.getString("Website","");
                String Country = sh.getString("Country","");
                String objective = sh.getString("objective","");
                int ResumeTemplateId = sh.getInt("ResumeTemplateId",0);

                Gson gson = new Gson();
                String jsonWorkArr0 = sh.getString("workArr0", "");
                String jsonWorkArr1 = sh.getString("workArr1", "");
                String jsonWorkArr2 = sh.getString("workArr2", "");
                String jsonEduArr0 = sh.getString("eduArr0", "");
                String jsonEduArr1 = sh.getString("eduArr1", "");
                String jsonEduArr2 = sh.getString("eduArr2", "");
                String jsonskillArr0 = sh.getString("skillArr0", "");
                String jsonskillArr1 = sh.getString("skillArr1", "");
                String jsonskillArr2 = sh.getString("skillArr2", "");
                String jsonskillArr3 = sh.getString("skillArr3", "");
                Type type = new TypeToken<ArrayList<String>>() {}.getType();
                List<String> workArr0 = gson.fromJson(jsonWorkArr0, type);
                List<String> workArr1 = gson.fromJson(jsonWorkArr1, type);
                List<String> workArr2 = gson.fromJson(jsonWorkArr2, type);
                List<String> eduArr0 = gson.fromJson(jsonEduArr0, type);
                List<String> eduArr1 = gson.fromJson(jsonEduArr1, type);
                List<String> eduArr2 = gson.fromJson(jsonEduArr2, type);
                List<String> skillArr0 = gson.fromJson(jsonskillArr0, type);
                List<String> skillArr1 = gson.fromJson(jsonskillArr1, type);
                List<String> skillArr2 = gson.fromJson(jsonskillArr2, type);
                List<String> skillArr3 = gson.fromJson(jsonskillArr3, type);

//                Toast.makeText(getActivity(), ""+workArr0+workArr1+workArr2+eduArr0+eduArr1+eduArr2+objective+ResumeTemplateId, Toast.LENGTH_SHORT).show();



                RequestQueue queue = Volley.newRequestQueue(getActivity());
                String url ="http://192.168.124.45/resumeit/create.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getActivity(), ""+response, Toast.LENGTH_LONG).show();
                                Log.i("API_responce", "onResponse: "+response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Data not send"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("first_name",first_name);
                        paramV.put("last_name",last_name);
                        paramV.put("profession",profession);
                        paramV.put("email",email);
                        paramV.put("MoNO",MoNO);
                        paramV.put("Website",Website);
                        paramV.put("Country",Country);
                        paramV.put("objective",objective);
//                        paramV.put("ResumeTemplateId",ResumeTemplateId);

                        return paramV;
                    }
                };
                queue.add(stringRequest);
                
                

//                Intent intent = new Intent(getActivity(), HomeSc.class);
//                startActivity(intent);
//                getActivity().finish();
            }
        });


        return binding.getRoot();
    }
}