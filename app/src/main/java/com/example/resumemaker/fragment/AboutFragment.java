package com.example.resumemaker.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.resumemaker.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class AboutFragment extends Fragment {
//    public AboutFragment() {
//        // Required empty public constructor
//    }
    private EditText edFname, edLname, edProfession;
    private Button btnNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);


        btnNext = view.findViewById(R.id.btnNext);
        edFname = view.findViewById(R.id.edFname);
        edLname = view.findViewById(R.id.edLastName);
        edProfession = view.findViewById(R.id.edProfession);



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
//                    DataBase Code
                    Toast.makeText(getActivity(), ""+FirstName+"|"+LastName+"|"+Profession, Toast.LENGTH_SHORT).show();

                }
            }
        });

        return view;
    }
}