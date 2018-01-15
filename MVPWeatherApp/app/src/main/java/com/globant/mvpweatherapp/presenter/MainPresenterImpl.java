package com.globant.mvpweatherapp.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.globant.mvpweatherapp.generic.BasePresenter;
import com.globant.mvpweatherapp.io.api.APIService;
import com.globant.mvpweatherapp.io.LiteWeatherResponse;
import com.globant.mvpweatherapp.io.ServiceAdapter;
import com.globant.mvpweatherapp.view.MainView;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by adoniram.dominguez on 21/12/2017.
 */

public class MainPresenterImpl<V extends MainView> extends BasePresenter<V> implements MainPresenter<V>{

  @Inject
  public MainPresenterImpl(){}

  @Override
  public void searchWeatherFor(@NonNull String city) {
    getView().onShowProgressBar(true);
    ServiceAdapter serviceAdapter = new ServiceAdapter();
    final Gson liteWeatherGson = serviceAdapter.buildLiteWeatherDeserializator();

    APIService apiService = serviceAdapter.searchWeatherFor(liteWeatherGson);

    apiService.
        listPossibleCities(city).
        subscribeOn(Schedulers.io()).
        observeOn(AndroidSchedulers.mainThread()).
        subscribe(new Observer<LiteWeatherResponse>() {
          @Override
          public void onSubscribe(Disposable d) {
            Log.d("XXX", "subscrito............");
          }

          @Override
          public void onNext(LiteWeatherResponse response) {
            if(response != null){
              getView().fillCountries(response.getLiteWeathers());
            }
          }

          @Override
          public void onError(Throwable e) {
            getView().onShowProgressBar(false);
            e.printStackTrace();
            Log.d("XXX", "Error " + e.getMessage());
          }

          @Override
          public void onComplete() {
            getView().onShowProgressBar(false);
            Log.d("XXX", "completada............");
          }
        });
  }

  @Override
  public void handleWeatherResponse(LiteWeatherResponse response) {

  }

  @Override
  public void handleWeatherResponseError(Throwable throwable) {

  }

}
