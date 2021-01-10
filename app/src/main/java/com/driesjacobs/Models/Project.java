package com.driesjacobs.Models;

import android.media.Image;
import android.provider.ContactsContract;

import java.io.Serializable;
import java.util.Date;


public class Project implements IProject, Serializable {
    private String title;
    private String description;
    private Integer image;
    private String author;
    private String date;
    private String url;

    private void setTitle(String title){
        this.title = title;
    }

    private void setDescription(String description){
        this.description = description;
    }

    private void setImage(Integer image){
        this.image = image;
    }

    private void setDate(String date){
        this.date = date;
    }

    private void setUrl(String url){
        this.url = url;
    }

    private void setAuthor(String author){
        this.author = author;
    }

    public Project(){
        this.setTitle("Default title");
        this.setDescription("Een omschrijving");
        this.setImage(-1);
        this.setDate(new Date().toString());
        this.setAuthor("Dries Jacobs");
        this.setUrl("http://www.http://driesjacobs.be/");
    }

    public Project(String title, String description, Integer image, String date, String url, String author){
        this.setTitle(title);
        this.setDescription(description);
        this.setImage(image);
        this.setDate(date);
        this.setAuthor(author);
        this.setUrl(url);
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

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public String getUrl() {
        return this.url;
    }
}
