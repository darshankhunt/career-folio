package com.example.resumemaker.fragment;

import static android.content.Context.MODE_PRIVATE;

import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.resumemaker.CreateResumeDataActivity;
import com.example.resumemaker.Model.UserModel;
import com.example.resumemaker.R;
import com.example.resumemaker.databinding.FragmentMyResumeBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;


public class MyResumeFragment extends Fragment {

    FragmentMyResumeBinding binding;
    String[] permissionArrays = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
    int REQUEST_CODE = 101;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyResumeBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        SharedPreferences sh = getActivity().getSharedPreferences("UserSignUpData", getContext().MODE_PRIVATE);
        String emailOfUser = sh.getString("email","");


        String pdfLink = "http://172.20.10.5/resumepdfapi/pdfs/"+emailOfUser+"/result_resume.pdf";
        String urlForFetchDataFromDB ="http://172.20.10.5/resumepdfapi/fetchresumeget.php";
        String urlForDeleteResume ="http://172.20.10.5/resumepdfapi/removeResumePost.php";

        RequestQueue queue = Volley.newRequestQueue(getActivity());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlForFetchDataFromDB,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String apiResponse = response;
                        String ResumeTempId = String.valueOf(apiResponse.charAt(apiResponse.length() - 1));
//                        Log.i("ResumeTempId",ResumeTempId);
                        String ResumePdfLink = apiResponse.substring(0, (apiResponse.length() - 1));
//                        Log.i("ResumePdfLink",ResumePdfLink);

                            if(ResumePdfLink.equals(emailOfUser+"/result_resume.pdf")){
                                binding.ResumeTxt.setVisibility(View.GONE);
                                binding.userResumeCard.setVisibility(View.VISIBLE);
                            }else{
                                binding.ResumeTxt.setVisibility(View.VISIBLE);
                                binding.userResumeCard.setVisibility(View.GONE);
                            }

                            if(ResumeTempId.equals("0")){
                                binding.imgResume.setImageResource(R.mipmap.resume0);
                            } else if (ResumeTempId.equals("1")) {
                                binding.imgResume.setImageResource(R.mipmap.resume1);
                            } else if (ResumeTempId.equals("2")) {
                                binding.imgResume.setImageResource(R.mipmap.resume2);
                            }else{
                                binding.imgResume.setImageResource(R.mipmap.resume0);
                            }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ErrorinFetchDataResume", error.getMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                paramV.put("emailOfUser", emailOfUser);
                return paramV;
            }
        };
        queue.add(stringRequest);


        binding.imgResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdfLink));
                startActivity(browserIntent);
            }
        });

        binding.btnDownloadResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(pdfLink));
                    request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                    request.setTitle("Download");
                    request.setDescription("Downloading file");
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,""+ System.currentTimeMillis());

                    DownloadManager manager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    manager.enqueue(request);
                    Toast.makeText(getActivity(), "Download Resume", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnEditResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateResumeDataActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        binding.btnRemoveResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, urlForDeleteResume,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Resume Delete Successfully!")){
                                    binding.ResumeTxt.setVisibility(View.VISIBLE);
                                    binding.userResumeCard.setVisibility(View.GONE);
                                    Toast.makeText(getActivity(), "Resume Delete Successfully!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("ErrorOfDeleteResume",error.getMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("emailOfUser", emailOfUser);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
        });

        return binding.getRoot();
    }
}