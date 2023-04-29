package com.example.resumemaker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.resumemaker.adapter.ResumeDetailsAdapter;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateResumeDataActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    public static ViewPager2 viewPager2;
    public static Map<String, String> aboutData = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_resume_data);
        getSupportActionBar().hide();
        
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);

        FragmentManager manager = getSupportFragmentManager();
        ResumeDetailsAdapter adapter = new ResumeDetailsAdapter(manager,getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("About").setIcon(R.drawable.ic_tab_about));
        tabLayout.addTab(tabLayout.newTab().setText("Contact").setIcon(R.drawable.ic_tab_contact));
        tabLayout.addTab(tabLayout.newTab().setText("Work").setIcon(R.drawable.ic_tab_work));
        tabLayout.addTab(tabLayout.newTab().setText("Education").setIcon(R.drawable.ic_tab_education));
        tabLayout.addTab(tabLayout.newTab().setText("Skills").setIcon(R.drawable.ic_tab_skills));
        tabLayout.addTab(tabLayout.newTab().setText("Summary").setIcon(R.drawable.ic_tab_summary));
        tabLayout.addTab(tabLayout.newTab().setText("Done").setIcon(R.drawable.ic_tab_done));

        tabLayout.addOnTabSelectedListener(CreateResumeDataActivity.this);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager2.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}