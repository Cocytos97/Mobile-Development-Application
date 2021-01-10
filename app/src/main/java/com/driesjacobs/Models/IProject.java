package com.driesjacobs.Models;

import android.media.Image;

import java.util.Date;

public interface IProject {
    String getTitle();
    Date getDate();
    String getDescription();
    String getImageUrl();
}
