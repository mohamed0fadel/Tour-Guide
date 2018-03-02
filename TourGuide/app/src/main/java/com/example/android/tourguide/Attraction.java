package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;

import java.io.Serializable;

/**
 * Created by MohamedFadel on 1/25/2018.
 */

public class Attraction implements Serializable {

    private String name;
    private String description;
    private int image;
    private Location location;

    public Attraction(String name, String description, int image,Location location) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
