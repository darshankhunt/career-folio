package com.example.resumemaker.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.resumemaker.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class AboutFragment extends Fragment {
    public AboutFragment() {
        // Required empty public constructor
    }

    private TextInputLayout tilFirstName, tilLastName, tilProfession;
    private Button btnNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);


        btnNext = view.findViewById(R.id.btnNext);
        tilFirstName = view.findViewById(R.id.tilFirstName);
        tilLastName = view.findViewById(R.id.tilLastName);
        tilProfession = view.findViewById(R.id.tilProfession);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FirstName = tilFirstName.getEditText().getText().toString().trim();
                String LastName = tilLastName.getEditText().getText().toString().trim();
                String Profession = tilProfession.getEditText().getText().toString().trim();

                if(FirstName.equals("")){
                    tilFirstName.setError("Please Enter FirstName");
                } else if (LastName.equals("")) {
                    tilFirstName.setError("Please Enter LastName");
                } else if (Profession.equals("")) {
                    tilProfession.setError("Please Enter Profession");
                }else {
                    Toast.makeText(getActivity(), ""+FirstName+"|"+LastName+"|"+Profession, Toast.LENGTH_SHORT).show();
                }

//                if(!FirstName.equals("") && !LastName.equals("") && !Profession.equals("")){
////                    String FirstName = tilFirstName.getEditText().getText().toString().trim();
////                    String LastName = tilLastName.getEditText().getText().toString().trim();
////                    String Profession = tilProfession.getEditText().getText().toString().trim();
//
//                    Toast.makeText(getActivity(), ""+FirstName+"|"+LastName+"|"+Profession, Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(getActivity(), "Hello World", Toast.LENGTH_SHORT).show();
//                }
            }
        });




        return view;
    }
}