package com.globant.mvpweatherapp.view;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.globant.mvpweatherapp.model.LiteWeather;

import java.util.ArrayList;

/**
 * Created by adoniram.dominguez on 21/12/2017.
 */

public interface MainView {

  void searchAction(@NonNull String query);

  void goToItemWithPosition(LiteWeather liteWeather, ImageView sharedImageView );

  void onShowProgressBar(boolean show);

  void fillCountries(ArrayList<LiteWeather> weathers);
}
