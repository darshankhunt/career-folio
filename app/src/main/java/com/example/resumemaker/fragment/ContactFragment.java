package com.example.resumemaker.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.resumemaker.R;
import com.google.android.material.textfield.TextInputLayout;

public class ContactFragment extends Fragment {
    public ContactFragment() {
        // Required empty public constructor
    }

    private Button btnNext;
    private TextInputLayout tilEmail, tilWebsite, tilCountry, tilMoNo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        btnNext = view.findViewById(R.id.btnNext);
        tilEmail = view.findViewById(R.id.tilEmail);
        tilMoNo = view.findViewById(R.id.tilMono);
        tilWebsite = view.findViewById(R.id.tilWebsite);
        tilCountry = view.findViewById(R.id.tilCountry);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = tilEmail.getEditText().getText().toString().trim();
                String Website = tilWebsite.getEditText().getText().toString().trim();
                String Country = tilCountry.getEditText().getText().toString().trim();
                String MoNO = tilMoNo.getEditText().getText().toString().trim();

            }
        });



        return view;
    }
}