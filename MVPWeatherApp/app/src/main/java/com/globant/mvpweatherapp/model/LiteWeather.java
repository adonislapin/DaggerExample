package com.globant.mvpweatherapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adoniram.dominguez on 21/06/2017.
 */

public class LiteWeather implements Parcelable {

    private int id;
    private String country;
    private String city;
    private String currentTemp;
    private String pressure;
    private String humidity;
    private String tempMin;
    private String tempMax;
    private String windSpeed;
    private String windDeg;
    private String clouds;
    private String mainWeather;
    private String weatherDescription;
    private String weatherIcon;
    private String cityFlag;

    protected LiteWeather(Parcel in) {
        id = in.readInt();
        country = in.readString();
        city = in.readString();
        currentTemp = in.readString();
        pressure = in.readString();
        humidity = in.readString();
        tempMin = in.readString();
        tempMax = in.readString();
        windSpeed = in.readString();
        windDeg = in.readString();
        clouds = in.readString();
        mainWeather = in.readString();
        weatherDescription = in.readString();
        weatherIcon = in.readString();
        cityFlag = in.readString();
    }

    public LiteWeather(){}

    public static final Creator<LiteWeather> CREATOR = new Creator<LiteWeather>() {
        @Override
        public LiteWeather createFromParcel(Parcel in) {
            return new LiteWeather(in);
        }

        @Override
        public LiteWeather[] newArray(int size) {
            return new LiteWeather[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(String currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
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

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(String windDeg) {
        this.windDeg = windDeg;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getMainWeather() {
        return mainWeather;
    }

    public void setMainWeather(String mainWeather) {
        this.mainWeather = mainWeather;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getCityFlag() {
        return cityFlag;
    }

    public void setCityFlag(String cityFlag) {
        this.cityFlag = cityFlag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(country);
        dest.writeString(city);
        dest.writeString(currentTemp);
        dest.writeString(pressure);
        dest.writeString(humidity);
        dest.writeString(tempMin);
        dest.writeString(tempMax);
        dest.writeString(windSpeed);
        dest.writeString(windDeg);
        dest.writeString(clouds);
        dest.writeString(mainWeather);
        dest.writeString(weatherDescription);
        dest.writeString(weatherIcon);
        dest.writeString(cityFlag);
    }
}
