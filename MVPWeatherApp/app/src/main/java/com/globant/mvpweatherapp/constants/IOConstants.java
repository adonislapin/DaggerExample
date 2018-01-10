package com.globant.mvpweatherapp.constants;

/**
 * Created by adoniram.dominguez on 21/06/2017.
 */

public class IOConstants {

    public static final String BASE_URI_CITY = "http://openweathermap.org";
    public static final String URI_CITY = "/data/2.5/find?callback=jQuery19109414666835487111_1498078722289&type=like&sort=population&cnt=30&appid=b6907d289e10d714a6e88b30761fae22&_=1498078722290";

    public static final String BASE_FLAGS_URL = "http://openweathermap.org/images/flags/";
    public static final String BASE_WEATHER_IMG_URL = "http://openweathermap.org/img/w/";
    public static final String PNG = ".png";
    public static final String CITY_PAGE = "/city/";
    public static final String URL_SHARE_WEATHER = BASE_URI_CITY + CITY_PAGE;

    public static final String BASE_URL_API = "http://api.openweathermap.org";
    public static final String WEATHER_SERVICE = "/data/2.5/weather?APPID=b6907d289e10d714a6e88b30761fae22&units=metric";
    public static final String DAILY_WEATHER = "/data/2.5/forecast/daily?units=metric&appid=b6907d289e10d714a6e88b30761fae22";
}
