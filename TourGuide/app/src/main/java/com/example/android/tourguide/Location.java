package com.example.android.tourguide;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by MohamedFadel on 1/26/2018.
 */

public class Location implements Serializable{
    private String latitude;
    private String longitude;

    public Location(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * makes Uri for the location using latitude and longitude
     * @return location Uri
     */
    public Uri getUri(){
        Uri geoLocation = Uri.parse("geo:" + latitude + "," + longitude);
        return geoLocation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
