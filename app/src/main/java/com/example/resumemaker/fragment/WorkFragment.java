package com.example.resumemaker.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.resumemaker.R;
import com.google.android.material.textfield.TextInputLayout;

public class WorkFragment extends Fragment {



    public WorkFragment() {
        // Required empty public constructor
    }
    EditText startDate0;
    private LinearLayout lLayoutCard;
    private int count = 0;
    Button btnAddExp;
    private CardView workCard0, workCard1, workCard2;
    private EditText edStartDate0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_work, container, false);

        btnAddExp = view.findViewById(R.id.btnAddExp);
        lLayoutCard = view.findViewById(R.id.lLayoutCard);
        workCard0 = view.findViewById(R.id.WorkCard0);
        workCard1 = view.findViewById(R.id.WorkCard1);
        workCard2 = view.findViewById(R.id.WorkCard2);
//        lLayoutCard.setVisibility(View.VISIBLE);
        edStartDate0 = view.findViewById(R.id.edStartDate0);


//        edStartDate0.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String str=edStartDate0.getText().toString();
//                int textLength=edStartDate0 .getText().length();
//                if (textLength == 3) {
//                    if (!str.contains("-")) {
//                        edStartDate0 .setText(new StringBuilder(edStartDate0 .getText().toString()).insert(str.length() - 1, "/").toString());
//                        edStartDate0 .setSelection(edStartDate0 .getText().length());
//                    }
//                }
//            }
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

        btnAddExp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (count==0){
                    workCard0.setVisibility(View.VISIBLE);
                    count++;
                } else if(count==1){
                    workCard1.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==2) {
                    workCard2.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==3) {
                    Toast.makeText(getActivity(), "You can't insert more than 3 experience.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }


    public void addSlash(){
        edStartDate0.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str=edStartDate0.getText().toString();
                int textLength=edStartDate0 .getText().length();
                if (textLength == 3) {
                    if (!str.contains("-")) {
                        edStartDate0 .setText(new StringBuilder(edStartDate0 .getText().toString()).insert(str.length() - 1, "/").toString());
                        edStartDate0 .setSelection(edStartDate0 .getText().length());
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}