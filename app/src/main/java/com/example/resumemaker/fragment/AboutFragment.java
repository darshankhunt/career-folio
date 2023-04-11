package com.example.resumemaker.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.Model.UserModel;
import com.example.resumemaker.R;
import com.google.gson.Gson;


public class AboutFragment extends Fragment {

    private EditText edFname, edLname, edProfession;
    private Button btnNext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sh.edit();
        btnNext = view.findViewById(R.id.btnNext);
        edFname = view.findViewById(R.id.edFname);
        edLname = view.findViewById(R.id.edLastName);
        edProfession = view.findViewById(R.id.edProfession);

        String fn = sh.getString("first_name","");
        String ln = sh.getString("last_name","");
        String pr = sh.getString("profession","");
        if(!fn.equals(""))
            edFname.setText(fn);
        if(!ln.equals(""))
            edLname.setText(ln);
        if(!pr.equals(""))
            edProfession.setText(pr);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FirstName = edFname.getText().toString().trim();
                String LastName = edLname.getText().toString().trim();
                String Profession = edProfession.getText().toString().trim();
                if(FirstName.equals("")){
                    edFname.setError("Please Enter FirstName");
                } else if (LastName.equals("")) {
                    edLname.setError("Please Enter LastName");
                } else if (Profession.equals("")) {
                    edProfession.setError("Please Enter Profession");
                }else {
/*                    UserModel u=new UserModel(FirstName,LastName,Profession);
                    u.setfName(FirstName);
                    u.setlName(LastName);
                    u.setProfession(Profession);*/


                    /*Gson gson = new Gson();
                    String json = gson.toJson(u);
                    editor.putString("about",json);*/

                    editor.putString("first_name", FirstName);
                    editor.putString("last_name", LastName);
                    editor.putString("profession", Profession);
                    editor.commit();

                    /*CreateResumeDataActivity.aboutData.put("first_name", FirstName);
                    CreateResumeDataActivity.aboutData.put("last_name", LastName);
                    CreateResumeDataActivity.aboutData.put("profession", Profession);
                    Toast.makeText(getActivity(), ""+CreateResumeDataActivity.aboutData, Toast.LENGTH_SHORT).show();*/

                    CreateResumeDataActivity.viewPager2.setCurrentItem(1);
                }
            }
        });

        return view;
    }
}