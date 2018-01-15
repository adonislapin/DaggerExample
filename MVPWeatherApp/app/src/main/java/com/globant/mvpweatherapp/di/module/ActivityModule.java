package com.globant.mvpweatherapp.di.module;

import android.app.Activity;
import android.content.Context;

import com.globant.mvpweatherapp.di.anotation.ActivityContext;
import com.globant.mvpweatherapp.di.anotation.PerActivity;
import com.globant.mvpweatherapp.presenter.MainPresenter;
import com.globant.mvpweatherapp.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adoniram.dominguez on 15/01/2018.
 */

@Module
public class ActivityModule {

  private Activity mActivity;

  public ActivityModule(android.app.Activity activity) {
    this.mActivity = activity;
  }

  @Provides
  @ActivityContext
  Context provideContext() {
    return mActivity;
  }

  @Provides
  Activity provideActivity() {
    return mActivity;
  }

  @Provides
  @PerActivity
  MainPresenter<MainView> provideMainPresenter(
      MainPresenter<MainView> presenter) {
    return presenter;
  }


}
