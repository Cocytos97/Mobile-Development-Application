package com.driesjacobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.driesjacobs.Models.IProject;
import com.driesjacobs.Models.Project;
import com.driesjacobs.adapters.ProjectAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    private final String JSON_URL = "http";
    private final String XML_URL = "http";
    private final String CSV_URL = "http";

    private RecyclerView recyclerView;
    private ProjectAdapter adapter;
    private ArrayList<Project> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        projectList = new ArrayList<>();
        adapter = new ProjectAdapter(this, projectList);
        recyclerView.setAdapter(adapter);
        recyclerView.setVisibility(View.VISIBLE);
        try{
            getProjects();
        }catch (IOException ex){
            Log.e(TAG, ex.getMessage());
        }
    }

    private void getProjects() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(JSON_URL).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if(response.isSuccessful()){
                    String jsondata = response.body().string();
                    ObjectMapper mapper = new ObjectMapper();

                    projectList = mapper.readValue(jsondata, new TypeReference<List<Project>>(){});
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void addDummyData() {
        for (int i = 0; i < 10; i++) {
            projectList.add(new Project());
        }
        adapter.notifyDataSetChanged();
    }
}