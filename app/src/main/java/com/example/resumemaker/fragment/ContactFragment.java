package com.example.resumemaker.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONObject;

public class ContactFragment extends Fragment {
    public ContactFragment() {
        // Required empty public constructor
    }

    private Button btnNext;
    private TextInputLayout tilEmail, tilWebsite, tilCountry, tilMoNo;
    private EditText edEmail, edWebsite, edCountry, edMoNo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sh.edit();
        String em = sh.getString("email", "");
        String MoNo = sh.getString("MoNO", "");
        String web = sh.getString("Website", "");
        String coun = sh.getString("Country", "");

        btnNext = view.findViewById(R.id.btnNext);
        edEmail = view.findViewById(R.id.edForgetEmail);
        edWebsite = view.findViewById(R.id.edWebsite);
        edCountry = view.findViewById(R.id.edCountry);
        edMoNo = view.findViewById(R.id.edMoNo);

//        API Calling
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
                        String email = jsonObject.getString("email");
                        String contact_number = jsonObject.getString("contact_number");
                        String address = jsonObject.getString("address");
                        String website = jsonObject.getString("website");
                        edEmail.setText(email);
                        edMoNo.setText(contact_number);
                        edCountry.setText(address);
                        if(!website.equals("")){
                            edWebsite.setText(website);
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



        if(!em.equals(""))
            edEmail.setText(em);
        if(!MoNo.equals(""))
            edMoNo.setText(MoNo);
        if(!web.equals(""))
            edWebsite.setText(web);
        if(!coun.equals(""))
            edCountry.setText(coun);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = edEmail.getText().toString().trim();
                String Website = edWebsite.getText().toString().trim();
                String Country = edCountry.getText().toString().trim();
                String MoNO = edMoNo.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(Email.equals("")){
                    edEmail.setError("Please Enter Email Address");
                } else if (!Email.matches(emailPattern)) {
                    edEmail.setError("Please Enter Valid Email Address");
                } else if (MoNO.equals("")) {
                    edMoNo.setError("Please Enter Mobile Number");
                } else if (Country.equals("")) {
                    edCountry.setError("Please Enter your city or country");
                }else {
                    UserModel u = new UserModel(Email,MoNO,Website,Country);
                    u.setEmail(Email);
                    u.setContactNumber(MoNO);
                    if(Website.equals("")){
                        u.setWebsite("");
                    }else {
                        u.setWebsite(Website);
                    }
                    u.setWebsite(Website);
                    u.setCountry(Country);

                    editor.putString("email", u.getEmail());
                    editor.putString("MoNO", u.getContactNumber());
                    editor.putString("Website",u.getWebsite());
                    editor.putString("Country", u.getCountry());
                    editor.commit();
                    CreateResumeDataActivity.viewPager2.setCurrentItem(2);

                }
            }
        });
        return view;
    }
}