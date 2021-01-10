package com.driesjacobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.driesjacobs.Models.IProject;
import com.driesjacobs.Models.Project;
import com.driesjacobs.adapters.ProjectAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProjectAdapter adapter;
    private ArrayList<IProject> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewId);
    }

    private void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        projectList = new ArrayList<>();
        adapter = new ProjectAdapter(this, projectList);

        //getProjects();
        addDummyData();
    }

    private void getProjects() {

    }

    private void addDummyData(){
        for(int i = 0; i<10; i++){
            projectList.add(new Project());
        }
        adapter.notifyDataSetChanged();
    }
}