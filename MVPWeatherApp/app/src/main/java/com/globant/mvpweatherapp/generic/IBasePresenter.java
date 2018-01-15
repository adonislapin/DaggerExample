package com.globant.mvpweatherapp.generic;

/**
 * Created by adoniram.dominguez on 15/01/2018.
 */

public interface IBasePresenter<V extends BaseView> {

  void onAttach(V view);

  void onDetach();
}
