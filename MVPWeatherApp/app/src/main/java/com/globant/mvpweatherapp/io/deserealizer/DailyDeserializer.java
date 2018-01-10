package com.globant.mvpweatherapp.io.deserealizer;

import com.globant.mvpweatherapp.constants.JsonConstants;
import com.globant.mvpweatherapp.io.DailyWeatherResponse;
import com.globant.mvpweatherapp.model.Weather;
import com.globant.mvpweatherapp.utils.Utilities;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by adoniram.dominguez on 27/06/2017.
 */

public class DailyDeserializer implements JsonDeserializer<DailyWeatherResponse> {

    @Override
    public DailyWeatherResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        DailyWeatherResponse dailyWeatherResponse = gson.fromJson(json, DailyWeatherResponse.class);
        JsonArray array = json.getAsJsonObject().getAsJsonArray(JsonConstants.KEY_LIST);
        dailyWeatherResponse.setWeathers( getDailyWeatherForJsonArray(array) );

        return dailyWeatherResponse;
    }

    private ArrayList<Weather> getDailyWeatherForJsonArray(JsonArray array){
        ArrayList<Weather> weathers = new ArrayList<>();

        for(int i = 0 ; i < array.size(); i++){
            Weather weather = new Weather();
            JsonObject gsonTemp = array.get(i).getAsJsonObject();

            JsonObject tempObject = gsonTemp.get(JsonConstants.KEY_MAIN_TEMP).getAsJsonObject();
            weather.setCurrentTemp(tempObject.get(JsonConstants.KEY_DAY).getAsString());
            weather.setTempEve(tempObject.get(JsonConstants.KEY_EVE).getAsString());
            weather.setTempMor(tempObject.get(JsonConstants.KEY_MOR).getAsString());
            weather.setTempNight(tempObject.get(JsonConstants.KEY_NIGHT).getAsString());

            weather.setWindSpeed(gsonTemp.get(JsonConstants.KEY_WIND_SPEED).getAsString());
            weather.setDate(getDateForPosition(i));
            if(gsonTemp.has(JsonConstants.KEY_CLOUDS)){
                weather.setClouds(gsonTemp.get(JsonConstants.KEY_CLOUDS).getAsString());
            }

            JsonObject weatherJson = gsonTemp.getAsJsonArray(JsonConstants.KEY_WEATHER).get(0).getAsJsonObject();
            weather.setDescription(weatherJson.get(JsonConstants.KEY_WEATHER_DESC).getAsString());
            weather.setIcon( Utilities.getWeatherImageURLFromIcon(
                    weatherJson.get(JsonConstants.KEY_WEATHER_ICON).getAsString()));

            weathers.add(weather);
        }

        return weathers;
    }

    public static String getDateForPosition(int position) {
        String date = "";
        SimpleDateFormat sdfDate = new SimpleDateFormat("EEE MMM d yyyy");
        Date now = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DATE, position);

        date = sdfDate.format(cal.getTime());
        return date;
    }

}
