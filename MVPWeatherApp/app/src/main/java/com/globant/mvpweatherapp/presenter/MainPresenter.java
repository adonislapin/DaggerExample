package com.globant.mvpweatherapp.presenter;

import android.support.annotation.NonNull;

import com.globant.mvpweatherapp.io.LiteWeatherResponse;
import com.globant.mvpweatherapp.view.MainView;

/**
 * Created by adoniram.dominguez on 21/12/2017.
 */

public interface MainPresenter {

  void setMainView(MainView mView);

  void searchWeatherFor(@NonNull String city);

  void handleWeatherResponse(LiteWeatherResponse response);

  void handleWeatherResponseError(Throwable throwable);
}
