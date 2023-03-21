package com.example.resumemaker.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.resumemaker.R;

import java.util.HashMap;
import java.util.Map;

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

                    RequestQueue queue = Volley.newRequestQueue(getActivity());
                    String url ="http://172.20.10.5/resumeit/create.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if(response.equals("Success")){
                                        Toast.makeText(getActivity(), "Data Added!!", Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(getActivity(), response, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Error",error.getLocalizedMessage());
                        }
                    }){
                        protected Map<String, String> getParams(){
                            Map<String, String> paramV = new HashMap<>();
                            paramV.put("first_name", FirstName);
                            paramV.put("last_name", LastName);
                            paramV.put("profession", Profession);
                            return paramV;
                        }
                    };
                    queue.add(stringRequest);

//                    Toast.makeText(getActivity(), ""+FirstName+"|"+LastName+"|"+Profession, Toast.LENGTH_SHORT).show();

                }
            }
        });

        return view;
    }
}