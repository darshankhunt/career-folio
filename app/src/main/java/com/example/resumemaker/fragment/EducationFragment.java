package com.example.resumemaker.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.R;
import com.example.resumemaker.databinding.FragmentEducationBinding;
import com.example.resumemaker.databinding.FragmentWorkBinding;
import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EducationFragment extends Fragment implements View.OnClickListener{

    private static int count = 0;
    FragmentEducationBinding binding;
    private boolean isChbPresent0 = false;
    private boolean isChbPresent1 = false;
    private boolean isChbPresent2 = false;

    private ArrayList<String> eduArr0;
    private ArrayList<String> eduArr1;
    private ArrayList<String> eduArr2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_education, container, false);
        binding = FragmentEducationBinding.inflate(inflater,container,false);


        binding.btnAddEdu.setOnClickListener(this);
        binding.btnRemoveCard0.setOnClickListener(this);
        binding.btnRemoveCard1.setOnClickListener(this);
        binding.btnRemoveCard2.setOnClickListener(this);
        binding.btnStartDate0.setOnClickListener(this);
        binding.btnStartDate1.setOnClickListener(this);
        binding.btnStartDate2.setOnClickListener(this);
        binding.btnEndDate0.setOnClickListener(this);
        binding.btnEndDate1.setOnClickListener(this);
        binding.btnEndDate2.setOnClickListener(this);

        binding.chbPresentStudying0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isChbPresent0=true;
                    binding.edEndDate0.setText("Pursuing");
                }else {
                    isChbPresent0=false;
                    binding.edEndDate0.setText("");
                }
            }
        });
        binding.chbPresentStudying1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isChbPresent1=true;
                    binding.edEndDate1.setText("Pursuing");
                }else {
                    isChbPresent1=false;
                    binding.edEndDate1.setText("");
                }
            }
        });
        binding.chbPresentStudying2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    isChbPresent2=true;
                    binding.edEndDate2.setText("Pursuing");
                }else {
                    isChbPresent2=false;
                    binding.edEndDate2.setText("");
                }
            }
        });


        binding.btnEduSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(binding.EduCard0.getVisibility() == View.VISIBLE){
                    String courseName0 = binding.edCourseName0.getText().toString().trim();
                    String sclName0 = binding.edSclName0.getText().toString().trim();
                    String grade0 = binding.edGrade0.getText().toString().trim();
                    String startDate0 = binding.edStartDate0.getText().toString().trim();
                    String endDate0 = binding.edEndDate0.getText().toString().trim();
                    if(courseName0.isEmpty()){
                        binding.edCourseName0.setError("Please enter course name");
                    } else if (sclName0.isEmpty()) {
                        binding.edSclName0.setError("Please enter school name");
                    } else if (grade0.isEmpty()) {
                        binding.edGrade0.setError("Please enter grade");
                    } else if (startDate0.isEmpty()) {
                        binding.edStartDate0.setError("Please enter start date");
                    } else if (endDate0.isEmpty()) {
                        binding.edEndDate0.setError("Please enter end date");
                    } else{
                        if(!endDate0.equals("Pursuing")){
                            try{
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
                                Date dStartDate0 = formatter.parse(startDate0);
                                Date dEndDate0 = formatter.parse(endDate0);
                                if (dEndDate0.compareTo(dStartDate0)<0)
                                {
                                    Toast.makeText(getActivity(), "Start year is not bigger than End year", Toast.LENGTH_SHORT).show();
                                }else {
//                                    Code of DataBase
//                                    Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                                }
                            }catch (ParseException e1){
                                e1.printStackTrace();
                            }
                        }
                        eduArr0 = new ArrayList<String>();
                        eduArr0.add(courseName0);
                        eduArr0.add(sclName0);
                        eduArr0.add(grade0);
                        eduArr0.add(startDate0);
                        eduArr0.add(endDate0);
                        Gson gson = new Gson();
                        String edu0 = gson.toJson(eduArr0);
                        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =sh.edit();
                        editor.putString("eduArr0",edu0);
                        editor.commit();
                    }
                }

                if(binding.EduCard1.getVisibility() == View.VISIBLE){
                    String courseName1 = binding.edCourseName1.getText().toString().trim();
                    String sclName1 = binding.edSclName1.getText().toString().trim();
                    String grade1 = binding.edGrade1.getText().toString().trim();
                    String startDate1 = binding.edStartDate1.getText().toString().trim();
                    String endDate1 = binding.edEndDate1.getText().toString().trim();
                    if(courseName1.isEmpty()){
                        binding.edCourseName1.setError("Please enter course name");
                    } else if (sclName1.isEmpty()) {
                        binding.edSclName1.setError("Please enter school name");
                    } else if (grade1.isEmpty()) {
                        binding.edGrade1.setError("Please enter grade");
                    } else if (startDate1.isEmpty()) {
                        binding.edStartDate1.setError("Please enter start date");
                    } else if (endDate1.isEmpty()) {
                        binding.edEndDate1.setError("Please enter end date");
                    } else{
                        if(!endDate1.equals("Pursuing")){
                            try{
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
                                Date dStartDate0 = formatter.parse(startDate1);
                                Date dEndDate0 = formatter.parse(endDate1);
                                if (dEndDate0.compareTo(dStartDate0)<0)
                                {
                                    Toast.makeText(getActivity(), "Start year is not bigger than End year", Toast.LENGTH_SHORT).show();
                                }else {
//                                    Code of DataBase
//                                    Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                                }
                            }catch (ParseException e1){
                                e1.printStackTrace();
                            }
                        }
                        eduArr1 = new ArrayList<String>();
                        eduArr1.add(courseName1);
                        eduArr1.add(sclName1);
                        eduArr1.add(grade1);
                        eduArr1.add(startDate1);
                        eduArr1.add(endDate1);
                        Gson gson = new Gson();
                        String edu1 = gson.toJson(eduArr1);
                        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =sh.edit();
                        editor.putString("eduArr1",edu1);
                        editor.commit();
                    }
                }

                if(binding.EduCard2.getVisibility() == View.VISIBLE){
                    String courseName2 = binding.edCourseName2.getText().toString().trim();
                    String sclName2 = binding.edSclName2.getText().toString().trim();
                    String grade2 = binding.edGrade2.getText().toString().trim();
                    String startDate2 = binding.edStartDate2.getText().toString().trim();
                    String endDate2 = binding.edEndDate2.getText().toString().trim();
                    if(courseName2.isEmpty()){
                        binding.edCourseName2.setError("Please enter course name");
                    } else if (sclName2.isEmpty()) {
                        binding.edSclName2.setError("Please enter school name");
                    } else if (grade2.isEmpty()) {
                        binding.edGrade2.setError("Please enter grade");
                    } else if (startDate2.isEmpty()) {
                        binding.edStartDate2.setError("Please enter start date");
                    } else if (endDate2.isEmpty()) {
                        binding.edEndDate2.setError("Please enter end date");
                    } else{
                        if(!endDate2.equals("Pursuing")){
                            try{
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
                                Date dStartDate0 = formatter.parse(startDate2);
                                Date dEndDate0 = formatter.parse(endDate2);
                                if (dEndDate0.compareTo(dStartDate0)<0)
                                {
                                    Toast.makeText(getActivity(), "Start year is not bigger than End year", Toast.LENGTH_SHORT).show();
                                }else {
//                                    Code of DataBase
//                                    Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
                                }
                            }catch (ParseException e1){
                                e1.printStackTrace();
                            }
                        }
                        eduArr2 = new ArrayList<String>();
                        eduArr2.add(courseName2);
                        eduArr2.add(sclName2);
                        eduArr2.add(grade2);
                        eduArr2.add(startDate2);
                        eduArr2.add(endDate2);
                        Gson gson = new Gson();
                        String edu2 = gson.toJson(eduArr2);
                        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =sh.edit();
                        editor.putString("eduArr2",edu2);
                        editor.commit();

                    }
                }

                CreateResumeDataActivity.viewPager2.setCurrentItem(4);
            }
        });

        return binding.getRoot();
    }

    public void removeCard(CardView workCard){
        count--;
        workCard.setVisibility(View.GONE);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAddEdu:
                if (count==0){
                    binding.EduCard0.setVisibility(View.VISIBLE);
                    count++;
                } else if(count==1){
                    binding.EduCard0.setVisibility(View.VISIBLE);
                    binding.EduCard1.setVisibility(View.VISIBLE);
                    count++;
                } else if (count==2) {
                    binding.EduCard0.setVisibility(View.VISIBLE);
                    binding.EduCard1.setVisibility(View.VISIBLE);
                    binding.EduCard2.setVisibility(View.VISIBLE);
                    count++;
                } else if (count>=3) {
                    Toast.makeText(getActivity(), "You can't insert more than 3 Education.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRemoveCard0:
                removeCard(binding.EduCard0);
                break;
            case R.id.btnRemoveCard1:
                removeCard(binding.EduCard1);
                break;
            case R.id.btnRemoveCard2:
                removeCard(binding.EduCard2);
                break;
            case R.id.btnStartDate0:
                addYearPicker(binding.edStartDate0);
                break;
            case R.id.btnStartDate1:
                addYearPicker(binding.edStartDate1);
                break;
            case R.id.btnStartDate2:
                addYearPicker(binding.edStartDate2);
                break;
            case R.id.btnEndDate0:
                if(isChbPresent0==false){
                    addYearPicker(binding.edEndDate0);
                }
                break;
            case R.id.btnEndDate1:
                if(isChbPresent1==false){
                    addYearPicker(binding.edEndDate1);
                }
                break;
            case R.id.btnEndDate2:
                if(isChbPresent2==false){
                    addYearPicker(binding.edEndDate2);
                }
                break;
        }
    }

    public void addYearPicker(EditText StartDate){
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
                                StartDate.setText(year+"");
                                StartDate.setError(null);
                            }
                        }, year, month, date);
        ((ViewGroup)datePickerDialog.getDatePicker())
                .findViewById(Resources.getSystem().getIdentifier("month", "id", "android"))
                .setVisibility(View.GONE);
        ((ViewGroup)datePickerDialog.getDatePicker())
                .findViewById(Resources.getSystem().getIdentifier("day", "id", "android"))
                .setVisibility(View.GONE);
        datePickerDialog.getDatePicker().setMaxDate(cal.getTimeInMillis());
        datePickerDialog.setCancelable(false);
        datePickerDialog.show();
    }
}