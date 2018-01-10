package com.globant.mvpweatherapp.di;

import com.globant.mvpweatherapp.io.di.APIModule;
import com.globant.mvpweatherapp.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adoniram.dominguez on 26/12/2017.
 */

@Singleton
@Component(modules = {AppModule.class,
    MainPresenterModule.class,
    APIModule.class})
public interface AppComponent {

  void inject(MainActivity activity);

}