package com.driesjacobs.adapters;

import android.content.Context;
import android.net.IpPrefix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.driesjacobs.Models.IProject;
import com.driesjacobs.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectHolder> {
    private Context context;
    private List<IProject> projectList;

    public ProjectAdapter(Context context, ArrayList<IProject> projectList){
        this.context = context;
        this.projectList = projectList;
    }

    @NonNull
    @Override
    public ProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.project_custom_item_view, parent,false);
        return new ProjectHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectHolder holder, int position) {
        IProject project = projectList.get(position);
        holder.setDetails(project);
    }

    @Override
    public int getItemCount() {

        return projectList.size();
    }

    class ProjectHolder extends RecyclerView.ViewHolder {

        private TextView txtTitle, txtDate, txtDescription;
        private ImageView image;
        private Context context;

        ProjectHolder(View itemView, Context context){
            super(itemView);
            txtTitle = itemView.findViewById(R.id.titleViewId);
            txtDate = itemView.findViewById(R.id.textViewDateId);
            txtDescription = itemView.findViewById(R.id.textViewDescriptionId);
            image = itemView.findViewById(R.id.imageViewId);
            this.context = context;
        }

        void setDetails(IProject project){
            //txtTitle.setText(project.getTitle());
            //txtDate.setText(project.getDate().toString());
            //txtDescription.setText(project.getDescription());

            //https://www.journaldev.com/13759/android-picasso-tutorial#:~:text=To%20use%20the%20android%20Picasso,gradle%20file.&text=Android%20Picasso%20comes%20with%20its,Resizing%20and%20Scaling
            //Picasso.with(context).load(project.getImageUrl()).memoryPolicy(MemoryPolicy.NO_STORE).into(image);
        }

    }
}
