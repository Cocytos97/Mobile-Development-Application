package com.driesjacobs;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
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
        image.setImageResource(project.getImage());

        //setting share button
        shareLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, project.getTitle());
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, project.getUrl());

                final PackageManager pm = v.getContext().getPackageManager();
                final List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
                for (final ResolveInfo app : activityList) {
                    if ("com.twitter.android.PostActivity".equals(app.activityInfo.name)) {
                        final ActivityInfo activity = app.activityInfo;
                        final ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                        shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                        shareIntent.setComponent(name);
                        v.getContext().startActivity(shareIntent);
                        break;
                    }
                }
            }
        });
    }


}
