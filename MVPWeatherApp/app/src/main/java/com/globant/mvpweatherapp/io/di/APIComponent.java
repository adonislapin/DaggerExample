package com.globant.mvpweatherapp.io.di;

import com.globant.mvpweatherapp.io.repository.WeatherDataRepository;

/**
 * Created by adoniram.dominguez on 11/01/2018.
 */
/*
@Singleton
@Component(
    dependencies = ApplicationComponent.class,
    modules = {APIModule.class, }
)*/
public interface APIComponent {

  WeatherDataRepository providesRepository();

}
