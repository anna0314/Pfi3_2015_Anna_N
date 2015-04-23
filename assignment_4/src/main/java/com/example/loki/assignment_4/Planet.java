package com.example.loki.assignment_4;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Loki on 2015-04-21.
 */
public class Planet implements Serializable {
    String title;
    String temp;
    Drawable image;
    String summary;

    public Planet(String title, String temp, Drawable image, String summary) {
        this.title = title;
        this.temp = temp;
        this.image = image;
        this.summary = summary;

    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String isbn) {
        this.temp = isbn;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return title;
    }

    public String getSummary() {
        return summary;}

    public void setSummary(String summary){
        this.summary=summary;
    }

}