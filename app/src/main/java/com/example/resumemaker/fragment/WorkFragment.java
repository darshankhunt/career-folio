package com.example.resumemaker.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.resumemaker.R;

import java.util.Calendar;

public class WorkFragment extends Fragment implements View.OnClickListener {

    private static int count = 0;
    private CardView workCard0, workCard1, workCard2;
    private Button btnAddExp, btnWorkSave, btnRemoveCard0,btnRemoveCard1,btnRemoveCard2;

    private ImageButton btnStartDate0,btnStartDate1, btnStartDate2,  btnEndDate0, btnEndDate1, btnEndDate2;
    private EditText edCompanyName0,edCompanyName1,edCompanyName2,edJobTitle0,edJobTitle1,
            edJobTitle2, edStartDate0,edStartDate1,edStartDate2,edEndDate0, edEndDate1, edEndDate2,
            edWorkDesc0,edWorkDesc1,edWorkDesc2;
    private CheckBox chbPresentWorking0,chbPresentWorking1,chbPresentWorking2;

    private boolean isChbPresent0 = false;
    private boolean isChbPresent1 = false;
    private boolean isChbPresent2 = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work, container, false);

        btnAddExp = view.findViewById(R.id.btnAddExp);
        btnWorkSave = view.findViewById(R.id.btnWorkSave);
        btnStartDate0 = view.findViewById(R.id.btnStartDate0);
        btnStartDate1 = view.findViewById(R.id.btnStartDate1);
        btnStartDate2 = view.findViewById(R.id.btnStartDate2);
        btnEndDate0 = view.findViewById(R.id.btnEndDate0);
        btnEndDate1 = view.findViewById(R.id.btnEndDate1);
        btnEndDate2 = view.findViewById(R.id.btnEndDate2);
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
        chbPresentWorking0 = view.findViewById(R.id.chbPresentWorking0);
        chbPresentWorking1 = view.findViewById(R.id.chbPresentWorking1);
        chbPresentWorking2 = view.findViewById(R.id.chbPresentWorking2);

//        lLayoutCard.setVisibility(View.VISIBLE);

        //Add Exp Btn Click
        btnAddExp.setOnClickListener(this);
        btnRemoveCard0.setOnClickListener(this);
        btnRemoveCard1.setOnClickListener(this);
        btnRemoveCard2.setOnClickListener(this);

        //Add MonthPicker in StartDate
        btnStartDate0.setOnClickListener(this);
        btnStartDate1.setOnClickListener(this);
        btnStartDate2.setOnClickListener(this);
        btnEndDate0.setOnClickListener(this);
        btnEndDate1.setOnClickListener(this);
        btnEndDate2.setOnClickListener(this);

//        Code of disable endDate button on click of checkbox
        chbPresentWorking0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isChbPresent0=true;
                    edEndDate0.setText("Present");
                }else {
                    isChbPresent0=false;
                    edEndDate0.setText("");
                }
            }
        });
        chbPresentWorking1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isChbPresent1=true;
                    edEndDate1.setText("Present");
                }else {
                    isChbPresent1=false;
                    edEndDate1.setText("");
                }
            }
        });
        chbPresentWorking2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isChbPresent2=true;
                    edEndDate2.setText("Present");
                }else {
                    isChbPresent2=false;
                    edEndDate2.setText("");
                }
            }
        });


        btnWorkSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(workCard0.getVisibility() == View.VISIBLE){
                    String companyName0 = edCompanyName0.getText().toString().trim();
                    String jobTitle0 = edJobTitle0.getText().toString().trim();
                    String startDate0 = edStartDate0.getText().toString().trim();
                    String endDate0 = edEndDate0.getText().toString().trim();
                    String workDesc0 = edWorkDesc0.getText().toString().trim();
                    if(companyName0.isEmpty()){
                        edCompanyName0.setError("Please enter company name");
                    } else if (jobTitle0.isEmpty()) {
                        edJobTitle0.setError("Please enter job title");
                    } else if (startDate0.isEmpty()) {
                        edStartDate0.setError("Please enter start date");
                    } else if (endDate0.isEmpty()) {
                        edEndDate0.setError("Please enter end date");
                    } else if (workDesc0.isEmpty()) {
                        edWorkDesc0.setError("please enter work description");
                    }else{
//                        Data saved
                        Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                    }
                } else if(workCard1.getVisibility() == View.VISIBLE){
                    String companyName1 = edCompanyName1.getText().toString().trim();
                    String jobTitle1 = edJobTitle1.getText().toString().trim();
                    String startDate1 = edStartDate1.getText().toString().trim();
                    String endDate1 = edEndDate1.getText().toString().trim();
                    String workDesc1 = edWorkDesc1.getText().toString().trim();
                    if(companyName1.isEmpty()){
                        edCompanyName1.setError("Please enter company name");
                    } else if (jobTitle1.isEmpty()) {
                        edJobTitle1.setError("Please enter job title");
                    } else if (startDate1.isEmpty()) {
                        edStartDate1.setError("Please enter start date");
                    } else if (endDate1.isEmpty()) {
                        edEndDate1.setError("Please enter end date");
                    } else if (workDesc1.isEmpty()) {
                        edWorkDesc1.setError("please enter work description");
                    }else{
//                        Data saved
                        Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                    }
                } else if(workCard2.getVisibility() == View.VISIBLE){
                    String companyName2 = edCompanyName2.getText().toString().trim();
                    String jobTitle2 = edJobTitle2.getText().toString().trim();
                    String startDate2 = edStartDate2.getText().toString().trim();
                    String endDate2 = edEndDate2.getText().toString().trim();
                    String workDesc2 = edWorkDesc2.getText().toString().trim();
                    if(companyName2.isEmpty()){
                        edCompanyName2.setError("Please enter company name");
                    } else if (jobTitle2.isEmpty()) {
                        edJobTitle2.setError("Please enter job title");
                    } else if (startDate2.isEmpty()) {
                        edStartDate2.setError("Please enter start date");
                    } else if (endDate2.isEmpty()) {
                        edEndDate2.setError("Please enter end date");
                    } else if (workDesc2.isEmpty()) {
                        edWorkDesc2.setError("please enter work description");
                    }else{
//                        Data saved
                        Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                    }
                }

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
            case R.id.btnStartDate0:
                addMonthYearPicker(edStartDate0);
                break;
            case R.id.btnStartDate1:
                addMonthYearPicker(edStartDate1);
                break;
            case R.id.btnStartDate2:
                addMonthYearPicker(edStartDate2);
                break;
            case R.id.btnEndDate0:
                if(isChbPresent0==false){
                    addMonthYearPicker(edEndDate0);
                }
                break;
            case R.id.btnEndDate1:
                if(isChbPresent1==false){
                    addMonthYearPicker(edEndDate1);
                }
                break;
            case R.id.btnEndDate2:
                if(isChbPresent2==false){
                    addMonthYearPicker(edEndDate2);
                }
                break;
        }
    }


    public void addMonthYearPicker(EditText StartDate){
        final Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        int year = cal.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog =
                new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_DARK,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view,
                                                  int year,
                                                  int monthOfYear,
                                                  int dayOfMonth) {
                                StartDate.setText((monthOfYear + 1) + "-" + year);
                            }
                        }, year, month, date);
        ((ViewGroup)datePickerDialog.getDatePicker())
                .findViewById(Resources.getSystem().getIdentifier("day", "id", "android"))
                .setVisibility(View.GONE);
        datePickerDialog.getDatePicker().setMaxDate(cal.getTimeInMillis());
        datePickerDialog.setCancelable(false);
        datePickerDialog.show();
    }
}
