package com.globant.mvpweatherapp.io.api;

import com.globant.mvpweatherapp.constants.IOConstants;
import com.globant.mvpweatherapp.io.DailyWeatherResponse;
import com.globant.mvpweatherapp.io.LiteWeatherResponse;
import com.globant.mvpweatherapp.model.Weather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by adoniram.dominguez on 21/06/2017.
 */

public interface APIService {

  @GET(IOConstants.URI_CITY)
  Observable<LiteWeatherResponse> listPossibleCities(@Query("q") String city);

  @GET(IOConstants.WEATHER_SERVICE)
  Observable<Weather> getWeatherForId(@Query("id") String id);

  @GET(IOConstants.DAILY_WEATHER)
  Observable<DailyWeatherResponse> getDailyWeatherForId(@Query("id") String id);

}
