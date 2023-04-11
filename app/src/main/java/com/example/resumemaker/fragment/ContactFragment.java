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

import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.Model.UserModel;
import com.example.resumemaker.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

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
        edEmail = view.findViewById(R.id.edEmail);
        edWebsite = view.findViewById(R.id.edWebsite);
        edCountry = view.findViewById(R.id.edCountry);
        edMoNo = view.findViewById(R.id.edMoNo);

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