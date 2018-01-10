package com.globant.mvpweatherapp.utils;


import com.globant.mvpweatherapp.constants.IOConstants;

/**
 * Created by adoniram.dominguez on 22/06/2017.
 */

public class Utilities {

    public static String getCelsiusFromKelvinDegrees(Double deg){
        String degrees = "";

        degrees = String.valueOf( deg - 273.15D);
        String[] temp = degrees.split("\\.");

        if(temp.length > 1){
            if(temp[1].length() > 2){
                degrees = temp[0] + "." + temp[1].substring(0, 2);
            } else {
                degrees = temp[0] + "." + temp[1].substring(0, temp[1].length());
            }
        }
        return degrees;
    }

    public static String getWeatherImageURLFromIcon(String icon){
        return IOConstants.BASE_WEATHER_IMG_URL + icon + IOConstants.PNG;
    }

    public static String getCountryImageFrom(String country){
        return IOConstants.BASE_FLAGS_URL + country.toLowerCase() + IOConstants.PNG;
    }

}
