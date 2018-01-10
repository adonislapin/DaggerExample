package com.globant.mvpweatherapp.io.di;

import com.globant.mvpweatherapp.io.api.APIService;
import com.globant.mvpweatherapp.io.repository.WeatherDataSource;
import com.globant.mvpweatherapp.io.repository.remote.WeatherRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by adoniram.dominguez on 28/12/2017.
 */

@Module
public class APIModule {

  @Provides
  @Singleton
  public WeatherDataSource provideDataSource(WeatherRemoteDataSource weatherRemoteDataSource){
    return weatherRemoteDataSource;
  }

  @Provides
  @Singleton
  public APIService weatherAPIService(Retrofit retrofit){
    return retrofit.create(APIService.class);
  }
}
