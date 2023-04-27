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


public class MyResumeFragment extends Fragment {

    FragmentMyResumeBinding binding;
//    private static final String url = "http://172.20.10.5/ResumePDFAPI/fetchResumeGet.php";

    String[] permissionArrays = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
    int REQUEST_CODE = 101;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyResumeBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissionArrays, REQUEST_CODE );
        } else {
            // if already permition granted
            // PUT YOUR ACTION (Like Open cemara etc..)
        }


        binding.btnDownloadResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sh1 = getActivity().getSharedPreferences("UserSignUpData", getContext().MODE_PRIVATE);
                String emailOfUser = sh1.getString("email","");
                if(!emailOfUser.equals("")){
                    String pdfLink = "http://172.20.10.5/resumepdfapi/pdfs/"+emailOfUser+"/result_resume.pdf";

                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(pdfLink));
                    request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                    request.setTitle("Download");
                    request.setDescription("Downloading file");
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,""+ System.currentTimeMillis());

//                    DownloadManager manager = mContext.getSystemService(Context.DOWNLOAD_SERVICE);
//                    manager.enqueue(request);



                }else{

                }

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
//                editor.remove("ResumeTemplateId");

                Toast.makeText(getActivity(), "Delete Resume", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE ) {
            for (int i = 0; i < grantResults.length; i++) {


                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    // user rejected the permission
                    Toast.makeText(getContext(), "Permission denied", Toast.LENGTH_SHORT).show();

                }else {
                    // Code for Resume Show or Hide
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserSignUpData", getContext().MODE_PRIVATE);
                    int TotalResume = sharedPreferences.getInt("TotalResume",0);
                    if(TotalResume>0){
                        binding.ResumeTxt.setVisibility(View.GONE);
                        binding.userResumeCard.setVisibility(View.VISIBLE);
                    }else{
                        binding.ResumeTxt.setVisibility(View.VISIBLE);
                        binding.userResumeCard.setVisibility(View.GONE);
                    }

                    SharedPreferences sh = getActivity().getSharedPreferences("ResumeData", MODE_PRIVATE);
                    SharedPreferences.Editor editor =sh.edit();
                    int ResumeTemplateId = sh.getInt("ResumeTemplateId",0);
                    if(ResumeTemplateId==0){
                        binding.imgResume.setImageResource(R.mipmap.resume0);
                    } else if (ResumeTemplateId==1) {
                        binding.imgResume.setImageResource(R.mipmap.resume1);
                    } else if (ResumeTemplateId==2) {
                        binding.imgResume.setImageResource(R.mipmap.resume2);
                    }else{
                        binding.imgResume.setImageResource(R.mipmap.resume0);
                    }
//                    Toast.makeText(getContext(), "Permission allowed", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }



}