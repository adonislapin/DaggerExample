package com.globant.mvpweatherapp.di.module;

import android.app.Application;
import android.content.Context;

import com.globant.mvpweatherapp.di.anotation.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adoniram.dominguez on 26/12/2017.
 */

@Module
public class ApplicationModule {

  private final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides
  @ApplicationContext
  Context provideContext() {
    return mApplication;
  }

}
