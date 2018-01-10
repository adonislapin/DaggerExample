package com.globant.mvpweatherapp.app;

import android.app.Activity;
import android.app.Application;

import com.globant.mvpweatherapp.di.AppComponent;
import com.globant.mvpweatherapp.di.AppModule;
import com.globant.mvpweatherapp.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by adoniram.dominguez on 26/12/2017.
 */

public class WeatherApp extends Application implements HasActivityInjector{

  private AppComponent appComponent;

  @Inject
  DispatchingAndroidInjector<Activity> dispatchingActivityInjector;


  @Override
  public void onCreate() {
    super.onCreate();
   appComponent =  DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();
  }

  @Override
  public AndroidInjector<Activity> activityInjector() {
    return dispatchingActivityInjector;
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}
