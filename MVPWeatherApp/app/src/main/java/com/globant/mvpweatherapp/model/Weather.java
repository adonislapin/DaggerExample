package com.globant.mvpweatherapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adoniram.dominguez on 21/06/2017.
 */

public class Weather implements Parcelable {

    private String idCountry;
    private String tempMin;
    private String tempMax;
    private String currentTemp;
    private String seaLevel;
    private String sunrise;
    private String sunset;
    private String geoCords;
    private String tempEve;
    private String tempMor;
    private String tempNight;
    private String description;
    private String windSpeed;
    private String clouds;
    private String icon;
    private String date;

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(String currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(String seaLevel) {
        this.seaLevel = seaLevel;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getGeoCords() {
        return geoCords;
    }

    public void setGeoCords(String geoCords) {
        this.geoCords = geoCords;
    }

    public String getTempEve() {
        return tempEve;
    }

    public void setTempEve(String tempEve) {
        this.tempEve = tempEve;
    }

    public String getTempMor() {
        return tempMor;
    }

    public void setTempMor(String tempMor) {
        this.tempMor = tempMor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getTempNight() {
        return tempNight;
    }

    public void setTempNight(String tempNight) {
        this.tempNight = tempNight;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idCountry);
        dest.writeString(this.tempMin);
        dest.writeString(this.tempMax);
        dest.writeString(this.currentTemp);
        dest.writeString(this.seaLevel);
        dest.writeString(this.sunrise);
        dest.writeString(this.sunset);
        dest.writeString(this.geoCords);
        dest.writeString(this.tempEve);
        dest.writeString(this.tempMor);
        dest.writeString(this.tempNight);
        dest.writeString(this.description);
        dest.writeString(this.windSpeed);
        dest.writeString(this.clouds);
        dest.writeString(this.icon);
        dest.writeString(this.date);
    }

    public Weather() {
    }

    protected Weather(Parcel in) {
        this.idCountry = in.readString();
        this.tempMin = in.readString();
        this.tempMax = in.readString();
        this.currentTemp = in.readString();
        this.seaLevel = in.readString();
        this.sunrise = in.readString();
        this.sunset = in.readString();
        this.geoCords = in.readString();
        this.tempEve = in.readString();
        this.tempMor = in.readString();
        this.tempNight = in.readString();
        this.description = in.readString();
        this.windSpeed = in.readString();
        this.clouds = in.readString();
        this.icon = in.readString();
        this.date = in.readString();
    }

    public static final Parcelable.Creator<Weather> CREATOR = new Parcelable.Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel source) {
            return new Weather(source);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };
}
