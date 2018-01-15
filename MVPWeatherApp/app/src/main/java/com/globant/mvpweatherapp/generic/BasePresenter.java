package com.globant.mvpweatherapp.generic;

/**
 * Created by adoniram.dominguez on 15/01/2018.
 */

public class BasePresenter<V extends BaseView> implements IBasePresenter<V> {
  private V mView;

  @Override
  public void onAttach(V view) {
    mView = view;
  }

  @Override
  public void onDetach() {
    mView = null;
  }

  public V getView() {
    return mView;
  }

}
