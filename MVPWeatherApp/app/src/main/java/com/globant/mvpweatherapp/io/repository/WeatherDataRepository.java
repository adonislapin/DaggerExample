package com.globant.mvpweatherapp.io.repository;


import com.globant.mvpweatherapp.io.DailyWeatherResponse;
import com.globant.mvpweatherapp.io.LiteWeatherResponse;
import com.globant.mvpweatherapp.model.Weather;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by adoniram.dominguez on 11/01/2018.
 */

public class WeatherDataRepository implements WeatherDataSource {

  private final WeatherDataSource remoteDataSource;

  @Inject
  public WeatherDataRepository(
      WeatherDataSource remoteDataSource) {
    this.remoteDataSource = remoteDataSource;
  }

  @Override
  public Observable<LiteWeatherResponse> listPossibleCities(String city) {
    return remoteDataSource.listPossibleCities(city);
  }

  @Override
  public Observable<Weather> getWeatherForId(String id) {
    return remoteDataSource.getWeatherForId(id);
  }

  @Override
  public Observable<DailyWeatherResponse> getDailyWeatherForId(String id) {
    return remoteDataSource.getDailyWeatherForId(id);
  }
}
