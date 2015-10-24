package com.example.androidlearning.md;

import android.content.Context;

/**
 * Created by fcwl on 5/22/2015.
 */
public class CountryData {

    private String name;
    private String countryDetails;
    public String imageName = "vizagbeach";

    public static final String NAME_PREFIX = "Name_";
    public static final String DETAILS_PREFIX = "Details_";

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getCountryDetails() {
        return countryDetails;
    }

    public void setCountryDetails(String countryDetails) {
        this.countryDetails = countryDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceId(Context context) {
        try {
            return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
