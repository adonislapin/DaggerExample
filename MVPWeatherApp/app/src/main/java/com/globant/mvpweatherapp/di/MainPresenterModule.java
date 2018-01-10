package com.globant.mvpweatherapp.di;

import com.globant.mvpweatherapp.presenter.MainPresenter;
import com.globant.mvpweatherapp.presenter.MainPresenterImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by adoniram.dominguez on 27/12/2017.
 */

@Module
public abstract class MainPresenterModule {

  @Binds
  public abstract MainPresenter providesMainPresenter(MainPresenterImpl mainPresenter);

}
