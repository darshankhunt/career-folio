package com.example.resumemaker.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.Model.UserModel;
import com.example.resumemaker.R;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


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

        SharedPreferences sh1 = getActivity().getSharedPreferences("UserSignUpData", getContext().MODE_PRIVATE);
        String emailOfUser = sh1.getString("email","");
        String url = "http://172.20.10.5/resumepdfapi/fetchAllResumeDetailsGet.php?emailOfUser="+emailOfUser;
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONArray jsonArray = response;
                try {
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String firstName = jsonObject.getString("first_name");
                        String last_name = jsonObject.getString("last_name");
                        String profession = jsonObject.getString("profession");
                        edFname.setText(firstName);
                        edLname.setText(last_name);
                        edProfession.setText(profession);
                    }
                }
                catch (Exception w)
                {
                    w.printStackTrace();
                    Toast.makeText(getContext(),w.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ErrorAPI",error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);


        SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sh.edit();

        String fn = sh.getString("first_name","");
        String ln = sh.getString("last_name","");
        String pr = sh.getString("profession","");
        if(!fn.equals(""))
            edFname.setText(fn);
        if(!ln.equals(""))
            edLname.setText(ln);
        if(!pr.equals(""))
            edProfession.setText(pr);

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
                    editor.putString("first_name", FirstName);
                    editor.putString("last_name", LastName);
                    editor.putString("profession", Profession);
                    editor.commit();
                    CreateResumeDataActivity.viewPager2.setCurrentItem(1);
                }
            }
        });

        return view;
    }
}
