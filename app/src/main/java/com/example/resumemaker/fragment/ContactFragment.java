package com.example.resumemaker.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.resumemaker.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class ContactFragment extends Fragment {
    public ContactFragment() {
        // Required empty public constructor
    }

    private Button btnNext;
    private TextInputLayout tilEmail, tilWebsite, tilCountry, tilMoNo;
    private EditText edEmail, edWebsite, edCountry, edMoNo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        btnNext = view.findViewById(R.id.btnNext);
        edEmail = view.findViewById(R.id.edEmail);
        edWebsite = view.findViewById(R.id.edWebsite);
        edCountry = view.findViewById(R.id.edCountry);
        edMoNo = view.findViewById(R.id.edMoNo);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = edEmail.getText().toString().trim();
                String Website = edWebsite.getText().toString().trim();
                String Country = edCountry.getText().toString().trim();
                String MoNO = edMoNo.getText().toString().trim();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(Email.equals("")){
                    edEmail.setError("Please Enter Email Address");
                } else if (!Email.matches(emailPattern)) {
                    edEmail.setError("Please Enter Valid Email Address");
                } else if (MoNO.equals("")) {
                    edMoNo.setError("Please Enter Mobile Number");
                } else if (Website.equals("")){
//                    edWebsite.setError("Please Enter any website");
                } else if (Country.equals("")) {
                    edCountry.setError("Please Enter your city or country");
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
                            paramV.put("first_name", Email);
                            paramV.put("last_name", MoNO);
                            paramV.put("profession", Website);
                            paramV.put("profession", Country);
                            return paramV;
                        }
                    };
                    queue.add(stringRequest);


//                    Toast.makeText(getActivity(), ""+Email+"|"+Website+"|"+Country+"|"+MoNO, Toast.LENGTH_SHORT).show();
                }


            }
        });



        return view;
    }
}