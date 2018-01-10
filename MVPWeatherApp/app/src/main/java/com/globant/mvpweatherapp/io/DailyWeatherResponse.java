package com.globant.mvpweatherapp.io;


import com.globant.mvpweatherapp.model.Weather;

import java.util.ArrayList;

/**
 * Created by adoniram.dominguez on 27/06/2017.
 */

public class DailyWeatherResponse {

    ArrayList<Weather> weathers;

    public ArrayList<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(ArrayList<Weather> weathers) {
        this.weathers = weathers;
    }
}
