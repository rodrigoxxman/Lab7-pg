package com.rsalas.lab7.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rsalas.lab7.R;
import com.rsalas.lab7.adapters.CompanyAdapter;
import com.rsalas.lab7.repositories.CompanyRepository;

public class searchActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String word = getIntent().getStringExtra("word");
        CompanyAdapter businessAdapter = new CompanyAdapter();
        businessAdapter.setCompany(CompanyRepository.search(word));
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(businessAdapter);
    }
}
