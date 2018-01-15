package com.globant.mvpweatherapp.di.component;

import android.content.Context;

import com.globant.mvpweatherapp.app.WeatherApp;
import com.globant.mvpweatherapp.di.module.ApplicationModule;
import com.globant.mvpweatherapp.di.anotation.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adoniram.dominguez on 26/12/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

  void inject(WeatherApp app);

  @ApplicationContext
  Context context();

}