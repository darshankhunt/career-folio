package com.example.resumemaker.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.resumemaker.R;
import com.google.android.material.textfield.TextInputLayout;

public class WorkFragment extends Fragment {



    public WorkFragment() {
        // Required empty public constructor
    }
    EditText startDate0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_work, container, false);

        startDate0 = view.findViewById(R.id.edStartDate0);



        return view;
    }


}