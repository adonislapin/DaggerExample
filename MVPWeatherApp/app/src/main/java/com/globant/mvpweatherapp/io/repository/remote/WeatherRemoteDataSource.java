package com.globant.mvpweatherapp.io.repository.remote;

import com.globant.mvpweatherapp.io.DailyWeatherResponse;
import com.globant.mvpweatherapp.io.LiteWeatherResponse;
import com.globant.mvpweatherapp.io.api.APIService;
import com.globant.mvpweatherapp.io.repository.WeatherDataSource;
import com.globant.mvpweatherapp.model.Weather;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by adoniram.dominguez on 28/12/2017.
 */

public class WeatherRemoteDataSource implements WeatherDataSource {

  private final APIService mService;

  @Inject
  public WeatherRemoteDataSource(APIService mService) {
    this.mService = mService;
  }

  @Override
  public Observable<LiteWeatherResponse> listPossibleCities(String city) {
    return mService.listPossibleCities(city);
  }

  @Override
  public Observable<Weather> getWeatherForId(String id) {
    return mService.getWeatherForId(id);
  }

  @Override
  public Observable<DailyWeatherResponse> getDailyWeatherForId(String id) {
    return mService.getDailyWeatherForId(id);
  }
}
