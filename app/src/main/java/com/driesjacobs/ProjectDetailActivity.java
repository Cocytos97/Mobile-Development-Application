package com.driesjacobs;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.driesjacobs.Models.IProject;
import com.driesjacobs.Models.Project;

import java.util.List;

public class ProjectDetailActivity extends AppCompatActivity {
    private IProject project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_project);
        Intent intent = getIntent();
        project = (Project) intent.getSerializableExtra("project");

        initView();
    }

    private void initView() {
        TextView txtTitle, txtDescription, txtDate, txtAuthor;
        FrameLayout shareLayout;
        ImageView image;

        txtTitle = (TextView)findViewById(R.id.detailTitleViewId);
        txtAuthor = (TextView)findViewById(R.id.detailAuthorViewId);
        txtDescription = (TextView)findViewById(R.id.detailDescriptionViewId);
        txtDate = (TextView)findViewById(R.id.detailDateViewId);
        image = (ImageView) findViewById(R.id.detailImageViewId);
        shareLayout = (FrameLayout)findViewById(R.id.detailShareViewId);

        //setting data
        txtDescription.setText(project.getDescription());
        txtTitle.setText(project.getTitle());
        txtAuthor.setText(project.getAuthor());
        txtDate.setText(project.getDate());

        Integer imageInt = project.getImage();

        if(imageInt == -1){
            imageInt = R.drawable.default_image;
        }
        image.setImageResource(imageInt);

        //setting share button
        shareLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try{
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"driesjacobs007@gmail.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, project.getTitle());
                    i.putExtra(Intent.EXTRA_TEXT   , project.getUrl());
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(ProjectDetailActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception ex){
                    Log.e("error", ex.getMessage());
                }

            }
        });
    }


}
