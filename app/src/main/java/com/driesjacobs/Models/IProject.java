package com.driesjacobs.Models;

import android.media.Image;

import java.util.Date;

public interface IProject {
    String getTitle();
    String getDescription();
    Integer getImage();
    String getAuthor();
    String getDate();
    String getUrl();
}
