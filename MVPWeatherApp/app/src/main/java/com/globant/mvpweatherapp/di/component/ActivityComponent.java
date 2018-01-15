package com.globant.mvpweatherapp.di.component;

import com.globant.mvpweatherapp.di.anotation.PerActivity;
import com.globant.mvpweatherapp.di.module.ActivityModule;
import com.globant.mvpweatherapp.view.MainActivity;

import dagger.Component;

/**
 * Created by adoniram.dominguez on 15/01/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(MainActivity mainActivity);

}
