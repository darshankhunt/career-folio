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
import android.widget.Toast;

import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.Model.AboutRetrofit;
import com.example.resumemaker.Model.aboutModel;
import com.example.resumemaker.R;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AboutFragment extends Fragment {

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
                    SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor =sh.edit();
                    editor.putString("first_name", FirstName);
                    editor.putString("last_name", LastName);
                    editor.putString("profession", Profession);
                    editor.commit();
                    /*CreateResumeDataActivity.aboutData.put("first_name", FirstName);
                    CreateResumeDataActivity.aboutData.put("last_name", LastName);
                    CreateResumeDataActivity.aboutData.put("profession", Profession);
                    Toast.makeText(getActivity(), ""+CreateResumeDataActivity.aboutData, Toast.LENGTH_SHORT).show();*/
                    CreateResumeDataActivity.viewPager2.setCurrentItem(1);
//                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.20.10.5/resumeit/")
//                            .addConverterFactory(GsonConverterFactory.create()).build();
//
//                    AboutRetrofit aboutRetrofit = retrofit.create(AboutRetrofit.class);
//
//                    aboutModel aboutModel = new aboutModel(FirstName,LastName,Profession);
//                    Call<aboutModel> call =  aboutRetrofit.PostData(aboutModel);
//                    call.enqueue(new Callback<com.example.resumemaker.Model.aboutModel>() {
//                        @Override
//                        public void onResponse(Call<com.example.resumemaker.Model.aboutModel> call, Response<com.example.resumemaker.Model.aboutModel> response) {
//                            Toast.makeText(getActivity(), "Data inserted", Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onFailure(Call<com.example.resumemaker.Model.aboutModel> call, Throwable t) {
//                            Toast.makeText(getActivity(), "Data not inserted", Toast.LENGTH_SHORT).show();
//                        }
//                    });


//                    String url ="http://172.20.10.5/resumeit/create.php";
//                    Toast.makeText(getActivity(), ""+FirstName+"|"+LastName+"|"+Profession, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}