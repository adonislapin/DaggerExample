package com.globant.mvpweatherapp.io.deserealizer;

import com.globant.mvpweatherapp.constants.JsonConstants;
import com.globant.mvpweatherapp.io.LiteWeatherResponse;
import com.globant.mvpweatherapp.model.LiteWeather;
import com.globant.mvpweatherapp.utils.Utilities;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by adoniram.dominguez on 22/06/2017.
 */

public class LiteWeatherDeserealizer implements JsonDeserializer<LiteWeatherResponse> {

    @Override
    public LiteWeatherResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        LiteWeatherResponse liteWeatherResponse = gson.fromJson(json, LiteWeatherResponse.class);
        JsonArray array = json.getAsJsonObject().getAsJsonArray(JsonConstants.KEY_LIST);

        liteWeatherResponse.setLiteWeathers(deserializeLiteWeatherArray(array));

        return liteWeatherResponse;
    }

    private ArrayList<LiteWeather> deserializeLiteWeatherArray(JsonArray array){
        ArrayList<LiteWeather> liteWeathers = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            LiteWeather liteWeather =  new LiteWeather();
            JsonObject gsonTemp = array.get(i).getAsJsonObject();

            liteWeather.setId(gsonTemp.get(JsonConstants.KEY_ID).getAsInt());
            liteWeather.setCountry(gsonTemp.get(JsonConstants.KEY_COUNTRY).getAsString());

            JsonObject jsonMain = gsonTemp.getAsJsonObject(JsonConstants.KEY_MAIN);
            liteWeather.setCurrentTemp(Utilities.getCelsiusFromKelvinDegrees(jsonMain.get(JsonConstants.KEY_MAIN_TEMP)
            .getAsDouble()));
            liteWeather.setTempMax(Utilities.getCelsiusFromKelvinDegrees(jsonMain.get(JsonConstants.KEY_MAIN_TEMP_MIN)
                    .getAsDouble()));
            liteWeather.setTempMin(Utilities.getCelsiusFromKelvinDegrees(jsonMain.get(JsonConstants.KEY_MAIN_TEMP_MAX)
                    .getAsDouble()));
            liteWeather.setHumidity(jsonMain.get(JsonConstants.KEY_MAIN_HUMIDITY).getAsString());
            liteWeather.setPressure(jsonMain.get(JsonConstants.KEY_MAIN_PRESSURE).getAsString());

            JsonObject jsonWind = gsonTemp.getAsJsonObject(JsonConstants.KEY_WIND);
            liteWeather.setWindSpeed(jsonWind.get(JsonConstants.KEY_WIND_SPEED).getAsString());
            if(jsonWind.has(JsonConstants.KEY_WIND_DEG)){
                liteWeather.setWindDeg(jsonWind.get(JsonConstants.KEY_WIND_DEG).getAsString());
            } else {
                liteWeather.setWindDeg("0");
            }

            jsonWind.has(JsonConstants.KEY_WIND_DEG);

            liteWeather.setCity(gsonTemp.getAsJsonObject(JsonConstants.KEY_SYS)
            .get(JsonConstants.KEY_SYS_COUNTRY).getAsString());

            liteWeather.setClouds(gsonTemp.getAsJsonObject(JsonConstants.KEY_CLOUDS)
                    .get(JsonConstants.KEY_CLOUDS_ALL).getAsString());

            JsonObject weatherJson = gsonTemp.getAsJsonArray(JsonConstants.KEY_WEATHER).get(0).getAsJsonObject();
            liteWeather.setMainWeather(weatherJson.get(JsonConstants.KEY_WEATHER_MAIN).getAsString());
            liteWeather.setWeatherDescription(weatherJson.get(JsonConstants.KEY_WEATHER_DESC).getAsString());
            liteWeather.setWeatherIcon( Utilities.getWeatherImageURLFromIcon(
                    weatherJson.get(JsonConstants.KEY_WEATHER_ICON).getAsString()));
            liteWeather.setCityFlag(Utilities.getCountryImageFrom(liteWeather.getCity()));

            liteWeathers.add(liteWeather);
        }
        
        return liteWeathers;
    }
}
