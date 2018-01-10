package com.globant.mvpweatherapp.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

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
@Singleton
public class MainPresenterImpl  implements MainPresenter{
  private MainView mView;

  @Inject
  public MainPresenterImpl(){}

  @Override
  public void setMainView(MainView mView){
    this.mView = mView;
  }

  @Override
  public void searchWeatherFor(@NonNull String city) {
    mView.onShowProgressBar(true);
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
              mView.fillCountries(response.getLiteWeathers());
            }
          }

          @Override
          public void onError(Throwable e) {
            mView.onShowProgressBar(false);
            e.printStackTrace();
            Log.d("XXX", "Error " + e.getMessage());
          }

          @Override
          public void onComplete() {
            mView.onShowProgressBar(false);
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
