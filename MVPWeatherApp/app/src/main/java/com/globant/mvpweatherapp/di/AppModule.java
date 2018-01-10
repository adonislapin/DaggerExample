package com.globant.mvpweatherapp.di;

import android.app.Application;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adoniram.dominguez on 26/12/2017.
 */

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
      mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
      return mApplication;
    }

}
