package com.driesjacobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.driesjacobs.Models.IProject;
import com.driesjacobs.Models.Project;
import com.driesjacobs.adapters.ProjectAdapter;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProjectAdapter adapter;
    private ArrayList<IProject> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewId);
        initView();
    }

    private void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        projectList = new ArrayList<>();
        adapter = new ProjectAdapter(this, projectList);
        recyclerView.setAdapter(adapter);
        recyclerView.setVisibility(View.VISIBLE);
        //getProjects();
        addDummyData();
    }

    private void getProjects() {

    }

    private void addDummyData(){
        for(int i = 0; i<10; i++){
            projectList.add(new Project("Titel", "Omschrijving", new Date(), "https://postimg.cc/jn5862X0"));
        }
        adapter.notifyDataSetChanged();
    }
}