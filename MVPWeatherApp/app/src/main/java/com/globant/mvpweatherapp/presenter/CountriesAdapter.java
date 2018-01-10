package com.globant.mvpweatherapp.presenter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.globant.mvpweatherapp.R;
import com.globant.mvpweatherapp.model.LiteWeather;
import com.globant.mvpweatherapp.view.IClickInterface;

import java.util.List;


/**
 * Created by Adoniram on 09/06/2017.
 */

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.MyViewHolder> {

    private Context mContext;
    private List<LiteWeather> countries;
    private IClickInterface mInterface;

    public CountriesAdapter(Context mContext, List<LiteWeather> countries, IClickInterface mInterface) {
        this.mContext = mContext;
        this.countries = countries;
        this.mInterface = mInterface;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView country, weatherInfo, weatherDesc;
        public ImageView weatherImg, imgFlag;

        public MyViewHolder(View view) {
            super(view);
            country = view.findViewById(R.id.country);
            weatherInfo = view.findViewById(R.id.weather_info);
            weatherDesc = view.findViewById(R.id.weather_desc);
            weatherImg = view.findViewById(R.id.weather_img);
            imgFlag = view.findViewById(R.id.country_flag);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_weather, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        LiteWeather country = countries.get(position);
        holder.country.setText(country.getCountry() + ", " + country.getCity());
        holder.weatherInfo.setText(country.getCurrentTemp() + " From : " + country.getTempMin() + " to " + country.getTempMax());
        holder.weatherDesc.setText(country.getWeatherDescription());

        Glide.with(mContext).load(country.getWeatherIcon()).into(holder.weatherImg);
        Glide.with(mContext).load(country.getCityFlag()).into(holder.imgFlag);

        ViewCompat.setTransitionName(holder.weatherImg , "img_" + position);
        holder.weatherImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mInterface != null){
                    mInterface.onClickItem((LiteWeather) v.getTag());
                }
                //mCountryController.goToItemWithPosition(holder.getAdapterPosition(), holder.weatherImg);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


}
