package com.example.resumemaker.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.resumemaker.R;

public class WorkFragment extends Fragment implements View.OnClickListener {
    public WorkFragment() {
        // Required empty public constructor
    }

    private static int count = 0;
    private CardView workCard0, workCard1, workCard2;
    private Button btnAddExp, btnWorkSave, btnRemoveCard0,btnRemoveCard1,btnRemoveCard2;
    private EditText edCompanyName0,edCompanyName1,edCompanyName2,edJobTitle0,edJobTitle1,
            edJobTitle2, edStartDate0,edStartDate1,edStartDate2,edEndDate0, edEndDate1, edEndDate2,
            edWorkDesc0,edWorkDesc1,edWorkDesc2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work, container, false);

        btnAddExp = view.findViewById(R.id.btnAddExp);
        btnWorkSave = view.findViewById(R.id.btnWorkSave);
//      All three Cards
        workCard0 = view.findViewById(R.id.WorkCard0);
        workCard1 = view.findViewById(R.id.WorkCard1);
        workCard2 = view.findViewById(R.id.WorkCard2);
        edCompanyName0 = view.findViewById(R.id.edCompanyName0);
        edCompanyName1 = view.findViewById(R.id.edCompanyName1);
        edCompanyName2 = view.findViewById(R.id.edCompanyName2);
        edJobTitle0 = view.findViewById(R.id.edJobTitle0);
        edJobTitle1 = view.findViewById(R.id.edJobTitle1);
        edJobTitle2 = view.findViewById(R.id.edJobTitle2);
        edStartDate0 = view.findViewById(R.id.edStartDate0);
        edStartDate1 = view.findViewById(R.id.edStartDate1);
        edStartDate2 = view.findViewById(R.id.edStartDate2);
        edEndDate0 = view.findViewById(R.id.edEndDate0);
        edEndDate1 = view.findViewById(R.id.edEndDate1);
        edEndDate2 = view.findViewById(R.id.edEndDate2);
        edWorkDesc0 = view.findViewById(R.id.edWorkDesc0);
        edWorkDesc1 = view.findViewById(R.id.edWorkDesc1);
        edWorkDesc2 = view.findViewById(R.id.edWorkDesc2);
        btnRemoveCard0 = view.findViewById(R.id.btnRemoveCard0);
        btnRemoveCard1 = view.findViewById(R.id.btnRemoveCard1);
        btnRemoveCard2 = view.findViewById(R.id.btnRemoveCard2);


//        lLayoutCard.setVisibility(View.VISIBLE);
        addSlash(edStartDate0);
        addSlash(edStartDate1);
        addSlash(edStartDate2);
        addSlash(edEndDate0);
        addSlash(edEndDate1);
        addSlash(edEndDate2);




        //Add Exp Btn Click
        btnAddExp.setOnClickListener(this);
        btnRemoveCard0.setOnClickListener(this);
        btnRemoveCard1.setOnClickListener(this);
        btnRemoveCard2.setOnClickListener(this);

        btnWorkSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        });



        return view;
    }




    // Code for add slash in EditText
    public void addSlash(EditText edDate){
        edDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str=edDate.getText().toString();
                int textLength=edDate .getText().length();
                if (textLength == 3) {
                    if (!str.contains("-")) {
                        edDate .setText(new StringBuilder(edDate .getText().toString()).insert(str.length() - 1, "-").toString());
                        edDate .setSelection(edDate .getText().length());
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void removeCard(CardView workCard){
        count--;
        workCard.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRemoveCard0:
                removeCard(workCard0);
                break;
            case R.id.btnRemoveCard1:
                removeCard(workCard1);
                break;
            case R.id.btnRemoveCard2:
                removeCard(workCard2);
                break;
            case R.id.btnAddExp:
                if (count==0){
                    workCard0.setVisibility(View.VISIBLE);
                    count++;
                } else if(count==1){
                    workCard0.setVisibility(View.VISIBLE);
                    workCard1.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==2) {
                    workCard0.setVisibility(View.VISIBLE);
                    workCard1.setVisibility(View.VISIBLE);
                    workCard2.setVisibility(View.VISIBLE);
                    count++;
                } else if (count>=3) {
                    Toast.makeText(getActivity(), "You can't insert more than 3 experience.", Toast.LENGTH_SHORT).show();
                }
                break;
        }


    }
}
