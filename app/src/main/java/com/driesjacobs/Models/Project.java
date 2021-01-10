package com.driesjacobs.Models;

import android.media.Image;
import android.provider.ContactsContract;
import java.util.Date;


public class Project implements IProject{
    private String title;
    private Date date;
    private String description;
    private String imageUrl = "https://postimg.cc/jn5862X0";

    private void setTitle(String title){
        this.title = title;
    }

    private void setDescription(String description){
        this.description = description;
    }

    private void setDate(Date date){
        this.date = date;
    }

    private void setImage(String image){
        this.imageUrl = image;
    }

    public Project(){
        this("Titel", "Omschrijving", new Date(), "https://postimg.cc/jn5862X0");
    }

    public Project(String title, String description, Date date, String image){
        this.setTitle(title);
        this.setDescription(description);
        this.setDate(date);
        this.setImage(image);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public Date getDate() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getImageUrl() {
        return null;
    }
}
