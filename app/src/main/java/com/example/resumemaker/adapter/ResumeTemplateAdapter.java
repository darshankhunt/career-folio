package com.example.resumemaker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;

import com.example.resumemaker.R;

public class ResumeTemplateAdapter extends BaseAdapter {

    Context context;
    int[] arrResumeTemplate;

    public ResumeTemplateAdapter(FragmentActivity activity, int[] arrResumeTemplate) {
        this.context = activity;
        this.arrResumeTemplate = arrResumeTemplate;
    }


    @Override
    public int getCount() {
        return arrResumeTemplate.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.resume_templates,null);
        ImageView imgResume = view.findViewById(R.id.imgResume);
        imgResume.setImageResource(arrResumeTemplate[position]);

        return view;
    }
}
