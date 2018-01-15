package com.globant.mvpweatherapp.app;

import android.app.Application;

import com.globant.mvpweatherapp.di.component.ApplicationComponent;
import com.globant.mvpweatherapp.di.component.DaggerApplicationComponent;
import com.globant.mvpweatherapp.di.module.ApplicationModule;

/**
 * Created by adoniram.dominguez on 26/12/2017.
 */

public class WeatherApp extends Application{

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
   applicationComponent =  DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
   applicationComponent.inject(this);
  }

  public ApplicationComponent getComponent() {
    return applicationComponent;
  }
}
