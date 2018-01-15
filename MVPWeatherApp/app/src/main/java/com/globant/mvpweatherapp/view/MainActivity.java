package com.globant.mvpweatherapp.view;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.globant.mvpweatherapp.R;
import com.globant.mvpweatherapp.app.WeatherApp;
import com.globant.mvpweatherapp.constants.AppConstants;
import com.globant.mvpweatherapp.databinding.ActivityMainBinding;
import com.globant.mvpweatherapp.detail.view.WeatherDetailActivity;
import com.globant.mvpweatherapp.di.component.ActivityComponent;
import com.globant.mvpweatherapp.di.component.DaggerActivityComponent;
import com.globant.mvpweatherapp.di.module.ActivityModule;
import com.globant.mvpweatherapp.model.LiteWeather;
import com.globant.mvpweatherapp.presenter.CountriesAdapter;
import com.globant.mvpweatherapp.presenter.MainPresenter;
import com.globant.mvpweatherapp.utils.PopUpUtils;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView, IClickInterface{

  private ActivityMainBinding mBinding;
  private CountriesAdapter mCountriesAdapter;
  private ActivityComponent mActivityComponent;

  @Inject
  MainPresenter<MainView> mPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initDagger();
    mActivityComponent.inject(this);
    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    mPresenter.onAttach(this);

    setSupportActionBar(mBinding.toolbar);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);

    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    final SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
        .getActionView();
    if (null != searchView) {
      searchView.setSearchableInfo(searchManager
          .getSearchableInfo(getComponentName()));
      searchView.setIconifiedByDefault(false);
    }

    SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
      public boolean onQueryTextChange(String newText) {
        return true;
      }

      public boolean onQueryTextSubmit(String query) {
        searchView.clearFocus();
        searchAction(query);
        return true;
      }
    };
    searchView.setOnQueryTextListener(queryTextListener);

    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public void searchAction(@NonNull String query) {
    if(query != null){
      if(!query.equals("")){
        mPresenter.searchWeatherFor(query);
      } else {
        AlertDialog dialog = PopUpUtils.showUserMessage(this , getString(R.string.error_message_empty) );
        dialog.show();
      }
    } else {
      AlertDialog dialog = PopUpUtils.showUserMessage(this , getString(R.string.error_message_empty) );
      dialog.show();
    }
  }

  @Override
  public void goToItemWithPosition(LiteWeather liteWeather, ImageView sharedImageView) {
    Intent intent = new Intent( this, WeatherDetailActivity.class);
    intent.putExtra(AppConstants.KEY_COUNTRY, liteWeather);
    intent.putExtra(AppConstants.KEY_TRANSITION_NAME, ViewCompat.getTransitionName(sharedImageView));

    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
        this,
        sharedImageView,
        ViewCompat.getTransitionName(sharedImageView));

    this.startActivity(intent, options.toBundle());
  }

  @Override
  public void onShowProgressBar(boolean show) {
    if(mBinding.pgBar != null){
      mBinding.pgBar.setIndeterminate(show);
      mBinding.pgBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }
  }

  @Override
  public void fillCountries(ArrayList<LiteWeather> weathers) {
    if(weathers != null){
      if(weathers.size() > 0){

        mCountriesAdapter = new CountriesAdapter(MainActivity.this, weathers, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mBinding.recyclerView.setLayoutManager(mLayoutManager);
        mBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        mBinding.recyclerView.setAdapter(mCountriesAdapter);

        mBinding.recyclerView.setVisibility(View.VISIBLE);
      } else {
        AlertDialog dialog = PopUpUtils.showUserMessage(this, getString(R.string.error_message_not_found));
        dialog.show();
      }
    } else {
      AlertDialog dialog = PopUpUtils.showUserMessage(this, getString(R.string.error_message_no_items));
      dialog.show();
    }
  }

  @Override
  public void onClickItem(LiteWeather item) {

  }

  @Override
  public void showMessage(String message) {

  }

  private void initDagger(){
    mActivityComponent = DaggerActivityComponent.builder()
        .activityModule(new ActivityModule(this))
        .applicationComponent(((WeatherApp) getApplication()).getComponent())
        .build();
  }
}
