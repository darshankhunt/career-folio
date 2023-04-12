package com.example.resumemaker.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.Model.WorkModel;
import com.example.resumemaker.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private ArrayList<WorkModel> workArr0;
    private ArrayList<WorkModel> workArr1;
    private ArrayList<WorkModel> workArr2;

    private ArrayList<WorkModel> workList=new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work, container, false);

        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sh.edit();
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<WorkModel>>() {}.getType();
        String wA0 = sh.getString("workArr0","");
        List<WorkModel> wAL0 = gson.fromJson(wA0, type);
        String wA1 = sh.getString("workArr1","");
        List<WorkModel> wAL1 = gson.fromJson(wA1, type);
        String wA2 = sh.getString("workArr2","");
        List<WorkModel> wAL2 = gson.fromJson(wA2, type);


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


        if(wAL0==null){
            workCard0.setVisibility(View.GONE);
        }else {
            workCard0.setVisibility(View.VISIBLE);
            count++;
            edCompanyName0.setText(wAL0.get(0).getCompanyName());
            edJobTitle0.setText(wAL0.get(0).getJobTitle());
            edStartDate0.setText(wAL0.get(0).getStartDate());
            edEndDate0.setText(wAL0.get(0).getEndDate());
            edWorkDesc0.setText(wAL0.get(0).getWorkDesc());
        }
        if(wAL1==null){
            workCard1.setVisibility(View.GONE);
        }else {
            workCard1.setVisibility(View.VISIBLE);
            count++;
            edCompanyName1.setText(wAL1.get(0).getCompanyName());
            edJobTitle1.setText(wAL1.get(0).getJobTitle());
            edStartDate1.setText(wAL1.get(0).getStartDate());
            edEndDate1.setText(wAL1.get(0).getEndDate());
            edWorkDesc1.setText(wAL1.get(0).getWorkDesc());
        }
        if(wAL2==null){
            workCard2.setVisibility(View.GONE);
        }else {
            workCard2.setVisibility(View.VISIBLE);
            count++;
            edCompanyName2.setText(wAL2.get(0).getCompanyName());
            edJobTitle2.setText(wAL2.get(0).getJobTitle());
            edStartDate2.setText(wAL2.get(0).getStartDate());
            edEndDate2.setText(wAL2.get(0).getEndDate());
            edWorkDesc2.setText(wAL2.get(0).getWorkDesc());
        }


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
                    edEndDate0.setText("Pursuing");
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
                    edEndDate1.setText("Pursuing");
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
                    edEndDate2.setText("Pursuing");
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
                        if(!endDate0.equals("Pursuing")){
                            try{
                                SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
                                Date dStartDate0 = formatter.parse(startDate0);
                                Date dEndDate0 = formatter.parse(endDate0);
                                if (dEndDate0.compareTo(dStartDate0)<0)
                                {
                                    Toast.makeText(getActivity(), "Start date is not bigger than End date", Toast.LENGTH_SHORT).show();
                                }else {
//                                    Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                                }
                            }catch (ParseException e1){
                                e1.printStackTrace();
                            }
                        }

                        WorkModel w0 = new WorkModel(companyName0,jobTitle0,startDate0,endDate0,workDesc0);
                        w0.setCompanyName(companyName0);
                        w0.setJobTitle(jobTitle0);
                        w0.setStartDate(startDate0);
                        w0.setEndDate(endDate0);
                        w0.setWorkDesc(workDesc0);
                        workList.add(w0);
                        String work0 = gson.toJson(workList);
                        editor.putString("workList", work0);
                        editor.commit();

                        workArr0 = new ArrayList<WorkModel>();
                        workArr0.add(w0);
                        String wor0 = gson.toJson(workArr0);
                        editor.putString("workArr0", wor0);
                        editor.commit();


                    }
                }

                if(workCard1.getVisibility() == View.VISIBLE){
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
                        if(!endDate1.equals("Pursuing")){
                            try{
                                SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
                                Date dStartDate1 = formatter.parse(startDate1);
                                Date dEndDate1 = formatter.parse(endDate1);
                                if (dEndDate1.compareTo(dStartDate1)<0)
                                {
                                    Toast.makeText(getActivity(), "Start date is not bigger than End date", Toast.LENGTH_SHORT).show();
                                }else {
//                                    Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                                }
                            }catch (ParseException e1){
                                e1.printStackTrace();
                            }
                        }

                        WorkModel w1 = new WorkModel(companyName1,jobTitle1,startDate1,endDate1,workDesc1);
                        w1.setCompanyName(companyName1);
                        w1.setJobTitle(jobTitle1);
                        w1.setStartDate(startDate1);
                        w1.setEndDate(endDate1);
                        w1.setWorkDesc(workDesc1);
                        workList.add(w1);
                        String work1 = gson.toJson(workList);
                        editor.putString("workList",work1);

                        workArr1 = new ArrayList<WorkModel>();
                        workArr1.add(w1);
                        String wor1 = gson.toJson(workArr1);
                        editor.putString("workArr1", wor1);
                        editor.commit();

                    }
                }

                if(workCard2.getVisibility() == View.VISIBLE){
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
                        if(!endDate2.equals("Pursuing")){
                            try{
                                SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
                                Date dStartDate2 = formatter.parse(startDate2);
                                Date dEndDate2 = formatter.parse(endDate2);
                                if (dEndDate2.compareTo(dStartDate2)<0)
                                {
                                    Toast.makeText(getActivity(), "Start date is not bigger than End date", Toast.LENGTH_SHORT).show();
                                }else {
//                                    Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                                }
                            }catch (ParseException e1){
                                e1.printStackTrace();
                            }
                        }

                        WorkModel w2 = new WorkModel(companyName2,jobTitle2,startDate2,endDate2,workDesc2);
                        w2.setCompanyName(companyName2);
                        w2.setJobTitle(jobTitle2);
                        w2.setStartDate(startDate2);
                        w2.setEndDate(endDate2);
                        w2.setWorkDesc(workDesc2);
                        workList.add(w2);
                        String work2 = gson.toJson(workList);
                        editor.putString("workList",work2);
                        editor.commit();

                        workArr2 = new ArrayList<WorkModel>();
                        workArr2.add(w2);
                        String wor2 = gson.toJson(workArr2);
                        editor.putString("workArr2", wor2);
                        editor.commit();

                    }

                }

                CreateResumeDataActivity.viewPager2.setCurrentItem(3);
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
                                StartDate.setText((monthOfYear + 1) + "/" + year);
                                StartDate.setError(null);
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
