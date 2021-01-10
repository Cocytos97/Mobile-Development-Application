package com.driesjacobs.Models;

import android.media.Image;
import android.provider.ContactsContract;
import java.util.Date;


public class Project implements IProject{
    private String title;
    private String description;
    private Integer image;

    private void setTitle(String title){
        this.title = title;
    }

    private void setDescription(String description){
        this.description = description;
    }

    private void setImage(Integer image){
        this.image = image;
    }

    public Project(String title, String description, Integer image){
        this.setTitle(title);
        this.setDescription(description);
        this.setImage(image);
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Integer getImage() {
        return this.image;
    }
}
