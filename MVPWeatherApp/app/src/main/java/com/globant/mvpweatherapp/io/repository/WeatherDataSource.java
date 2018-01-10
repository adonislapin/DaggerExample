package com.globant.mvpweatherapp.io.repository;

import com.globant.mvpweatherapp.io.DailyWeatherResponse;
import com.globant.mvpweatherapp.io.LiteWeatherResponse;
import com.globant.mvpweatherapp.model.Weather;

import io.reactivex.Observable;

/**
 * Created by adoniram.dominguez on 28/12/2017.
 */

public interface WeatherDataSource {

  Observable<LiteWeatherResponse> listPossibleCities(String city);

  Observable<Weather> getWeatherForId(String id);

  Observable<DailyWeatherResponse> getDailyWeatherForId(String id);

}
