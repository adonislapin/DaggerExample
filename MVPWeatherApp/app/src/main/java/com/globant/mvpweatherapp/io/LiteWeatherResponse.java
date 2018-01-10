package com.globant.mvpweatherapp.io;

import com.globant.mvpweatherapp.model.LiteWeather;

import java.util.ArrayList;

/**
 * Created by adoniram.dominguez on 22/06/2017.
 */

public class LiteWeatherResponse {

    ArrayList<LiteWeather> liteWeathers;

    public ArrayList<LiteWeather> getLiteWeathers() {
        return liteWeathers;
    }

    public void setLiteWeathers(ArrayList<LiteWeather> liteWeathers) {
        this.liteWeathers = liteWeathers;
    }
}
