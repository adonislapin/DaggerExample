package com.globant.mvpweatherapp.presenter;

import android.support.annotation.NonNull;

import com.globant.mvpweatherapp.generic.IBasePresenter;
import com.globant.mvpweatherapp.io.LiteWeatherResponse;
import com.globant.mvpweatherapp.view.MainView;

/**
 * Created by adoniram.dominguez on 21/12/2017.
 */

public interface MainPresenter<V extends MainView> extends IBasePresenter<V> {

  void searchWeatherFor(@NonNull String city);

  void handleWeatherResponse(LiteWeatherResponse response);

  void handleWeatherResponseError(Throwable throwable);
}
