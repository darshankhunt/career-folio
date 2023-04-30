package com.example.resumemaker.fragment;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.android.volley.toolbox.Volley;
import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.Model.UserModel;
import com.example.resumemaker.R;
import com.example.resumemaker.databinding.FragmentSkillsBinding;
import com.example.resumemaker.databinding.FragmentSummaryBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SummaryFragment extends Fragment {

    FragmentSummaryBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSummaryBinding.inflate(inflater,container,false);
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
                            String objective = jsonObject.getString("objective");
                            binding.edObjective.setText(objective);
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




        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sh.edit();

        String ob = sh.getString("objective","");
        if(!ob.equals(""))
            binding.edObjective.setText(ob);

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

                    UserModel u = new UserModel(objective);
                    u.setObjective(objective);
                    editor.putString("objective", u.getObjective());
                    editor.commit();
                    CreateResumeDataActivity.viewPager2.setCurrentItem(6);
//                    Toast.makeText(getActivity(), ""+objective, Toast.LENGTH_SHORT).show();
                }
            }
        });



        return binding.getRoot();
    }
}