package com.globant.mvpweatherapp.io.deserealizer;

import com.globant.mvpweatherapp.constants.JsonConstants;
import com.globant.mvpweatherapp.model.Weather;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by adoniram.dominguez on 27/06/2017.
 */

public class WeatherDeserealizer implements JsonDeserializer<Weather> {
    @Override
    public Weather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Weather weather = getWeatherForJson(json.getAsJsonObject());

        return weather;
    }

    private Weather getWeatherForJson(JsonObject object){
        Weather weather = new Weather();

        weather.setIdCountry(object.get(JsonConstants.KEY_ID).getAsString());

        JsonObject mainObject = object.getAsJsonObject(JsonConstants.KEY_MAIN);
        weather.setCurrentTemp(mainObject.get(JsonConstants.KEY_MAIN_TEMP).getAsString());
        weather.setTempMin(mainObject.get(JsonConstants.KEY_MAIN_TEMP_MIN).getAsString());
        weather.setTempMax(mainObject.get(JsonConstants.KEY_MAIN_TEMP_MAX).getAsString());

        if(mainObject.has(JsonConstants.KEY_SEA_LEVEL)){
            weather.setSeaLevel(mainObject.get(JsonConstants.KEY_SEA_LEVEL).getAsString());
        }

        JsonObject coordObject = object.getAsJsonObject(JsonConstants.KEY_COORD);
        weather.setGeoCords( "[" + coordObject.get(JsonConstants.KEY_COORD_LAT).getAsString() + ", " +
                coordObject.get(JsonConstants.KEY_COORD_LON).getAsString() + "]" );

        JsonObject sysObject = object.getAsJsonObject(JsonConstants.KEY_SYS);
        weather.setSunrise(sysObject.get(JsonConstants.KEY_SUNRISE).getAsString());
        weather.setSunset(sysObject.get(JsonConstants.KEY_SUNSET).getAsString());

        return weather;
    }
}
