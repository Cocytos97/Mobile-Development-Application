package com.driesjacobs.adapters;

import android.content.Context;
import android.net.IpPrefix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.driesjacobs.Models.IProject;
import com.driesjacobs.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {
    private Context context;
    private List<IProject> projectList;

    public ProjectAdapter(Context context, ArrayList<IProject> projectList){
        this.context = context;
        this.projectList = projectList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.from(context).inflate(R.layout.project_custom_item_view, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final IProject project = projectList.get(position);
        holder.txtDescription.setText(project.getDescription());
        holder.txtTitle.setText(project.getTitle());
        holder.image.setImageResource(project.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, project.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtDescription;
        ImageView image;

        ViewHolder(View itemView){
            super(itemView);
            txtTitle = itemView.findViewById(R.id.textTitleId);
            txtDescription = itemView.findViewById(R.id.textDescriptionId);
            image = itemView.findViewById(R.id.imageViewId);
        }
    }
}
