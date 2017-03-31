package com.example.ravi.healthcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SearchHospital extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hospital);
        getSupportActionBar().setTitle("Search Hospital");
        getSupportActionBar().setHomeButtonEnabled(true);

    }
}
